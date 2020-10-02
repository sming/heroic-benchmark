package com.spotify.heroic.benchmarks.arithmetic.series.inbuilt;

import com.spotify.heroic.benchmarks.arithmetic.series.exp4j.OperatorFactoryImpl;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {

    private static Options buildOptions(Class klass) {
        return new OptionsBuilder()
            .include(klass.getSimpleName())
            .threads(4)
            .forks(1)
            .build();
    }

    public static void main(String[] args) throws RunnerException {
        {
            Options opt = buildOptions(OperatorFactoryImpl.class);
            new Runner(opt).run();
        }

        {
            Options opt = buildOptions(com.spotify.heroic.benchmarks.arithmetic.series.inbuilt.OperatorFactoryImpl.class);
            new Runner(opt).run();
        }

        {
            Options opt = buildOptions(com.spotify.heroic.benchmarks.arithmetic.series.mxparser.OperatorFactoryImpl.class);
            new Runner(opt).run();
        }
    }

}
