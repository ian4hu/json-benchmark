/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import org.openjdk.jmh.infra.Blackhole;

/**
 * @author jixu.hjx
 * @version $Id: JsonFunction.java, v 0.1 2018年12月29日 09:41 jixu.hjx Exp $
 */
public interface JsonFunction {
    default Object parseByStream(Document document, Blackhole blackhole) throws Exception {
        return parseByBind(document, blackhole);
    }

    default Object parseByDom(Document document, Blackhole blackhole) throws Exception {
        return parseByBind(document, blackhole);
    }

    Object parseByBind(Document document, Blackhole blackhole) throws Exception;

    default Object parseByBindWithoutAnnotationHints(Document document, Blackhole blackhole) throws Exception {
        return parseByBind(document, blackhole);
    }

    @FunctionalInterface
    interface ParseFunc {
        Object parse(JsonFunction func, Document document, Blackhole blackhole) throws Exception;
    }

    @FunctionalInterface
    interface ParserFunc {
        Object parse(Document document, Blackhole blackhole) throws Exception;
    }
}