package com.spotify.heroic.benchmarks.arithmetic.series;

import org.apache.commons.math3.util.Pair;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

@State(Scope.Benchmark)
public class BenchmarkState {
    public static volatile OperatorType currentOpType = OperatorType.ADD;

    // NOTE: these do not need to be volatile cos they're not mutated once
    // the tests have started running.
    public static Set<Integer> lenSeries = Set.of(100, 500, 4_000, 40_000);

    // NOTE: for now we're laser-focused on solving the bulk of user requests,
    // which is division, which enables them to do a ratio of e.g. successful
    // requests. Thus we're focusing on arithmetic with 2 Series only.
    public static ArrayList<Pair<List<Double>,List<Double>>> seriesPairs;

    @SuppressWarnings("MethodMayBeStatic")
    @Setup
    public void setup() {
        seriesPairs = new ArrayList<Pair<List<Double>,List<Double>>>();
        var rand = new Random();

        final int size = lenSeries.size();
        for (int len = 0; len < size; len++) {
            var series = new ArrayList<Double>(len);
            for (int j = 0; j < len; j++) {
                series.add(rand.nextDouble());
            }
            seriesPairs.add(new Pair<>(series, series));
        }
    }
}
