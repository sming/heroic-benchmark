package com.spotify.heroic.benchmarks.arithmetic.series.inbuilt;

import com.spotify.heroic.benchmarks.arithmetic.series.BenchmarkState;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorType;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkStateImplInbuilt extends BenchmarkState {

    @Override
    public void setupOperator() {
        operator = new OperatorFactoryImpl().createOperator(OperatorType.DIV);
    }


    @Benchmark
    public double measure() {
        return super.measureSimpleExpressionWithSeriesPair(this);
    }
}
