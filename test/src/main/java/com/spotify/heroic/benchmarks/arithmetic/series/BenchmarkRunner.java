package com.spotify.heroic.benchmarks.arithmetic.series;

import com.spotify.heroic.benchmarks.arithmetic.series.exp4j.Expression4jBenchmarkTest;
import org.NativeBenchmarkTest;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {

    private static Options buildOptions(Class foo) {
        return new OptionsBuilder()
            .include(Class.class.getSimpleName())
            .threads(4)
            .forks(1)
            .build();
    }

    public static void main(String[] args) throws RunnerException {
        {
            Options opt = buildOptions(NativeBenchmarkTest.class);
            new Runner(opt).run();
        }

        {
            Options opt = buildOptions(Expression4jBenchmarkTest.class);
            new Runner(opt).run();
        }
    }

}
