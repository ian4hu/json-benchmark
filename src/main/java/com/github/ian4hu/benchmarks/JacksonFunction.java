/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.openjdk.jmh.infra.Blackhole;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;

/**
 * @author jixu.hjx
 * @version $Id: JacksonFunction.java, v 0.1 2018年12月29日 10:59 jixu.hjx Exp $
 */
public class JacksonFunction implements JsonFunction {

    private static final JsonFactory  JSON_FACTORY = new JsonFactory();
    private static final ObjectMapper OBJECT_MAPPER;
    private static final ObjectMapper OBJECT_MAPPER_WITHOUT_ANNOTATION_HINTS;

    static {
        JSON_FACTORY.configure(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES, false);
        OBJECT_MAPPER = new ObjectMapper(JSON_FACTORY);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH));
        OBJECT_MAPPER_WITHOUT_ANNOTATION_HINTS = OBJECT_MAPPER.copy();
        OBJECT_MAPPER_WITHOUT_ANNOTATION_HINTS.setAnnotationIntrospector(NopAnnotationIntrospector.nopInstance());
    }

    @Override
    public Object parseByStream(Document document, Blackhole blackhole) throws Exception {
        JsonParser parser = JSON_FACTORY.createParser(document.getReader());
        return consumeParser(parser, blackhole);
    }

    @Override
    public Object parseByDom(Document document, Blackhole blackhole) throws Exception {
        return OBJECT_MAPPER.readTree(document.getReader());
    }

    @Override
    public Object parseByBind(Document document, Blackhole blackhole) throws Exception {
        return OBJECT_MAPPER.readValue(document.getReader(), OBJECT_MAPPER.constructType(document.getType()));
    }

    @Override
    public Object parseByBindWithoutAnnotationHints(Document document, Blackhole blackhole) throws Exception {
        return OBJECT_MAPPER_WITHOUT_ANNOTATION_HINTS.readValue(document.getReader(),
                OBJECT_MAPPER_WITHOUT_ANNOTATION_HINTS.constructType(document.getType()));
    }

    public Object consumeParser(JsonParser parser, Blackhole blackhole) throws IOException {
        int depth = 0;
        do {
            switch (parser.nextToken()) {
                case START_OBJECT:
                case START_ARRAY:
                    depth++;
                    break;
                case END_OBJECT:
                case END_ARRAY:
                    depth--;
                    break;
                case FIELD_NAME:
                    parser.getCurrentName();
                    break;
                case VALUE_STRING:
                    parser.getText();
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    parser.getLongValue();
                    break;
            }
        } while (depth > 0);
        parser.close();
        return parser;
    }
}