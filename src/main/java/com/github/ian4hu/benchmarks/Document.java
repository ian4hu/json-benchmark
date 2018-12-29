/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author jixu.hjx
 * @version $Id: Document.java, v 0.1 2018年12月29日 14:49 jixu.hjx Exp $
 */
public enum Document {
    TWEETS(new TypeHolder<List<Model.Tweet>>() {}.getType()),
    READER_SHORT(new TypeHolder<Model.Feed>() {}.getType()),
    READER_LONG(new TypeHolder<Model.Feed>() {}.getType());

    private final Type type;

    private final String content;

    private final byte[] bytes;

    Document(Type type) {
        this.type = type;
        this.content = resourceToString("/" + name() + ".json");
        this.bytes = content.getBytes(UTF_8);
    }

    Reader getReader() {
        return new StringReader(content);
    }

    String getContent() {
        return content;
    }

    byte[] getBytes() {
        return bytes;
    }

    InputStream getInputStream() {
        return new ByteArrayInputStream(bytes);
    }

    Type getType() {
        return type;
    }

    private static String resourceToString(String path) {
        try (InputStream in = Model.class.getResourceAsStream(path)) {
            if (in == null) {
                throw new IllegalArgumentException("No such file: " + path);
            }

            try (Reader reader = new InputStreamReader(in, UTF_8)) {
                char[] buffer = new char[8192];
                StringWriter writer = new StringWriter();
                int count;
                while ((count = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, count);
                }
                return writer.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}