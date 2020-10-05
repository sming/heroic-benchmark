package com.spotify.heroic.benchmarks.arithmetic.series;

import com.spotify.heroic.benchmarks.arithmetic.series.exp4j.BenchmarkStateImplExp4j;
import com.spotify.heroic.benchmarks.arithmetic.series.inbuilt.BenchmarkStateImplInbuilt;
import com.spotify.heroic.benchmarks.arithmetic.series.mxparser.BenchmarkStateImplMxParser;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * The entrypoint to this benchmarking tool.
 */
public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {
        int forks = 3;  // each fork is like a fresh JVM instance
        int warmupIterations = 10;  // # iterations to warm up CPU caches etc.
        int measurementIterations = 15; // # iterations in actual benchmarking

        // If we're running in development mode, we just want a quick run to confirm
        // our e.g. annotation changes - are correct.
        if (args != null && args.length == 1) {
            var arg = args[0];
            if (arg != null && arg.toLowerCase().contains("devmode")) {
                forks = 0;
                warmupIterations = 2;
                measurementIterations = 2;
            }
        }

        // Here we point JMH at all three series arithmetic implementations. For
        // some reason, BenchmarkRunner must be included, else no benchmarks are
        // detected by JMH ¯\_(ツ)_/¯
        var builder = new OptionsBuilder()
            .include(BenchmarkStateImplExp4j.class.getSimpleName())
            .include(BenchmarkStateImplMxParser.class.getSimpleName())
            .include(BenchmarkStateImplInbuilt.class.getSimpleName())
            .include(BenchmarkRunner.class.getSimpleName())
            .threads(4)
            .forks(forks)
            .warmupIterations(warmupIterations)
            .measurementIterations(measurementIterations)
            .build();

        new Runner(builder).run();
    }
}
