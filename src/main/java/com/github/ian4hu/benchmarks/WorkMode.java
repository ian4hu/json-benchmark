/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import org.openjdk.jmh.infra.Blackhole;

/**
 * @author jixu.hjx
 * @version $Id: WorkMode.java, v 0.1 2018年12月29日 13:46 jixu.hjx Exp $
 */
public enum WorkMode implements JsonFunction.ParseFunc {

    STREAM(JsonFunction::parseByStream),
    DOM(JsonFunction::parseByDom),
    BIND(JsonFunction::parseByBind),
    NO_ANNOTATION(JsonFunction::parseByBindWithoutAnnotationHints);

    private final JsonFunction.ParseFunc func;

    WorkMode(JsonFunction.ParseFunc func) {
        this.func = func;
    }

    @Override
    public Object parse(JsonFunction func, Document document, Blackhole blackhole) throws Exception {
        return this.func.parse(func, document, blackhole);
    }}