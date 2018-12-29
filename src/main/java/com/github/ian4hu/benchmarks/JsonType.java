/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

/**
 * @author jixu.hjx
 * @version $Id: JsonType.java, v 0.1 2018年12月29日 13:39 jixu.hjx Exp $
 */
public enum JsonType {
    GSON(new GsonFunction()),
    JACKSON(new JacksonFunction()),
    FAST_JSON(new FastJsonFunction()),
    DSL_JSON(new DslJsonFunction());

    JsonType(JsonFunction func) {
        this.func = func;
    }

    private final JsonFunction func;

    public JsonFunction getFunction() {
        return func;
    }
}