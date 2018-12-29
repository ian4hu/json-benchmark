/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import java.io.IOException;

import org.openjdk.jmh.infra.Blackhole;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * @author jixu.hjx
 * @version $Id: GsonFunction.java, v 0.1 2018年12月29日 10:19 jixu.hjx Exp $
 */
public class GsonFunction implements JsonFunction {

    private static final Gson GSON = new GsonBuilder()
            .setDateFormat("EEE MMM dd HH:mm:ss Z yyyy")
            .create();

    @Override
    public Object parseByStream(Document document, Blackhole blackhole) throws Exception {
        JsonReader reader = new JsonReader(document.getReader());
        Object o = consumeReader(reader);
        reader.close();
        return o;
    }

    @Override
    public Object parseByDom(Document document, Blackhole blackhole) throws Exception {
        return new JsonParser().parse(document.getReader());
    }

    @Override
    public Object parseByBind(Document document, Blackhole blackhole) throws Exception {
        return GSON.fromJson(document.getReader(), document.getType());
    }

    @Override
    public Object parseByBindWithoutAnnotationHints(Document document, Blackhole blackhole) throws Exception {
        return parseByBind(document, blackhole);
    }

    private Object consumeReader(JsonReader reader) throws IOException {
        while (true) {
            switch (reader.peek()) {
                case BEGIN_ARRAY:
                    reader.beginArray();
                    break;
                case END_ARRAY:
                    reader.endArray();
                    break;
                case BEGIN_OBJECT:
                    reader.beginObject();
                    break;
                case END_OBJECT:
                    reader.endObject();
                    break;
                case NAME:
                    reader.nextName();
                    break;
                case BOOLEAN:
                    reader.nextBoolean();
                    break;
                case NULL:
                    reader.nextNull();
                    break;
                case NUMBER:
                    reader.nextLong();
                    break;
                case STRING:
                    reader.nextString();
                    break;
                case END_DOCUMENT:
                    return reader;
                default:
                    throw new IllegalArgumentException("Unexpected token" + reader.peek());
            }
        }
    }
}