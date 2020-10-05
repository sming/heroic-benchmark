package com.spotify.heroic.benchmarks.arithmetic.series;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiFunction;
import org.apache.commons.math3.util.Pair;
import org.openjdk.jmh.annotations.Setup;

public abstract class BenchmarkState {
    private Object safe = new Object();

    // NOTE: these do not need to be volatile cos they're not mutated once
    // the tests have started running.
    public Set<Integer> lenSeries = Set.of(100, 500, 4_000, 40_000);

    // NOTE: for now we're laser-focused on solving the bulk of user requests,
    // which is division, which enables them to do a ratio of e.g. successful
    // requests. Thus we're focusing on arithmetic with 2 Series only.
    public ArrayList<Pair<List<Double>, List<Double>>> seriesPairs;

    public BiFunction<Double, Double, Double> operator;

    public abstract void setupOperator();

    @Setup
    public synchronized void setup() {
            if (seriesPairs == null) {
            seriesPairs = new ArrayList<Pair<List<Double>, List<Double>>>();
            var rand = new Random();

            for (int seriesLen : lenSeries) {
                var series = createRandomSeries(rand, seriesLen);
                var seriesB = createRandomSeries(rand, seriesLen);
                seriesPairs.add(new Pair<>(series, seriesB));
            }
        }
        setupOperator();
    }

    private static ArrayList<Double> createRandomSeries(Random rand, int seriesLen) {
        var series = new ArrayList<Double>(seriesLen);
        for (int j = 0; j < seriesLen; j++) {
            series.add(rand.nextDouble());
        }

        return series;
    }

    public abstract double measure();

  /**
   * Exercises the different arithmetic implementations.
   * <p>
   * Takes a list of pairs of List[Double]'s, iterates the outer list, then the
   * inner, apply-ing the pair of random Double's with the suppiled operator.
   * <p>
   * @param state passed in by JMH. Has the random doubles needed for
   * @return
   */
  protected static double measureSimpleExpressionWithSeriesPair(BenchmarkState state) {
        double result = 0.0;

        for (var seriesPair : state.seriesPairs) {

            var first = seriesPair.getFirst();
            var second = seriesPair.getSecond();

            int size = first.size();
            for (int i = 0; i < size; i++) {
                result += state.operator.apply(first.get(i), second.get(i));
            }
        }

        return result;
    }}
