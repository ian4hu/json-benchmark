/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import org.openjdk.jmh.infra.Blackhole;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.JsonReader;

/**
 *
 * @author jixu.hjx
 * @version $Id: DslJsonFunction.java, v 0.1 2018年12月29日 18:07 jixu.hjx Exp $
 */
public class DslJsonFunction implements JsonFunction {

    private static final DslJson<Object> DSL_JSON = new DslJson<>();

    @Override
    public Object parseByBind(Document document, Blackhole blackhole) throws Exception {
        return DSL_JSON.deserialize(document.getType(), document.getInputStream());
    }

}