/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import org.openjdk.jmh.infra.Blackhole;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.parser.JSONToken;

/**
 * @author jixu.hjx
 * @version $Id: FastJsonFunction.java, v 0.1 2018年12月29日 11:25 jixu.hjx Exp $
 */
public class FastJsonFunction implements JsonFunction {

    @Override
    public Object parseByStream(Document document, Blackhole blackhole) throws Exception {
        JSONReaderScanner scanner = new JSONReaderScanner(document.getReader());
        return consumeScanner(scanner, blackhole);
    }

    @Override
    public Object parseByDom(Document document, Blackhole blackhole) throws Exception {
        return JSON.parseObject(document.getContent());
    }

    @Override
    public Object parseByBind(Document document, Blackhole blackhole) throws Exception {
        return JSON.parseObject(document.getContent(), document.getType());
    }

    private Object consumeScanner(JSONReaderScanner scanner, Blackhole blackhole) {
        int depth = 0;
        scanner.nextToken();
        boolean eof = false;
        while (!eof) {
            switch (scanner.token()) {
                case JSONToken.LBRACE:
                    ++depth;
                    scanner.nextToken();
                    break;
                case JSONToken.RBRACE:
                    --depth;
                    scanner.nextToken();
                    break;
                case JSONToken.SET:
                case JSONToken.TREE_SET:
                case JSONToken.LBRACKET:
                    ++depth;
                    scanner.nextToken();
                    break;
                case JSONToken.RBRACKET:
                    --depth;
                    scanner.nextToken();
                    break;
                case JSONToken.COLON:
                case JSONToken.COMMA:
                    scanner.nextToken();
                    break;
                case JSONToken.FALSE:
                case JSONToken.TRUE:
                case JSONToken.NULL:
                case JSONToken.NEW:
                case JSONToken.IDENTIFIER:
                case JSONToken.LITERAL_STRING:
                case JSONToken.LITERAL_INT:
                case JSONToken.LITERAL_FLOAT:
                case JSONToken.LITERAL_ISO8601_DATE:
                    blackhole.consume(scanner.stringVal());
                    scanner.nextToken();
                    break;
                case JSONToken.EOF:
                    eof = true;
                    if (depth != 0) {
                        throw new IllegalStateException("JSON parse error");
                    }
                    break;
                default:
                    throw new IllegalStateException(
                            "JSON token missed '" + scanner.tokenName() + "'" + scanner.token() + " - " + scanner.pos());
            }
        }

        return scanner;
    }
}