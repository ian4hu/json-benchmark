/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.WarmupMode;

/**
 * @author jixu.hjx
 * @version $Id: JsonBenchmark.java, v 0.1 2018年12月29日 09:30 jixu.hjx Exp $
 */
@State(Scope.Benchmark)
public class JsonBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .jvmArgs(args)
                .include(JsonBenchmark.class.getSimpleName())
                .warmupMode(WarmupMode.BULK)
                .forks(1)
                .warmupIterations(2)
                .measurementIterations(5)
                .param("type", JsonType.FAST_JSON.name())
                .param("mode", WorkMode.STREAM.name())
                .shouldFailOnError(true)
                .build();
        new Runner(options).run();
    }

    @Param
    public JsonType type;

    @Param
    public WorkMode mode;

    @Param
    public Document document;

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void benchmark(Blackhole blackhole) throws Exception {
        mode.parse(type.getFunction(), document, blackhole);
    }

}