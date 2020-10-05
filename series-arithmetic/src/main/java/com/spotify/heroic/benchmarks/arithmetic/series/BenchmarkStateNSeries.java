package com.spotify.heroic.benchmarks.arithmetic.series;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * NOTE that this class is unused at present as it's more flexible than we need,
 * in that it supports operations upon many series when in fact almost all Use
 * Cases are of simply A / B.
 */
@State(Scope.Benchmark)
public class BenchmarkStateNSeries {
    public static volatile OperatorType currentOpType = OperatorType.ADD;

    // NOTE: these do not need to be volatile cos they're not mutated once
    // the tests have started running.
    public static Set<Integer> lenSeries = Set.of(1, 10, 100, 500, 4_000, 40_000);

    public static Set<Integer> numSeries = Set.of(2, 10, 100, 500, 4_000);
    public static ArrayList<List<List<Double>>> matrices;

    /*

    SERIES_LENGTHS   o    oo    ooo    oooo
    SERIES_COUNTS    o    oo    ooo    oooo

    MATRIX DEF: List<List<Pair<int,int>>>

        (o,o)    (o,oo)    (o,ooo)    (o,oooo)
        (oo,o)    (oo,oo)    (oo,ooo)    (oo,oooo)
        ...
        (oooo,o)    (oooo,oo)    (oooo,ooo)    (oooo,oooo)

    MATRIX DATA: series  - List<double>
                 input params: series' - List<series> - List<List<double>>
                 all input params: List<series'> - List<List<List<double>>> i.e. effectively a list of matrices.
    */

    @SuppressWarnings("MethodMayBeStatic")
    @Setup
    public void setup() {
        var seriesDefinitions = new HashMap<Integer, Integer>();

        // build matrices defs
        for (int len : lenSeries) {
            for (int num : numSeries) {
                seriesDefinitions.put(num, len);
            }
        }

        /*
        [
            Matrix1, Matrix2, Matrix3...
        ]
        ->
        List<List<List<Double>>> matrices
         */
        matrices = new ArrayList<List<List<Double>>>();
        var rand = new Random();

        for (var pair : seriesDefinitions.entrySet()) {
            int num = pair.getKey();
            int len = pair.getValue();

            var matrix = new ArrayList<List<Double>>(num);
            for (int i = 0; i < num; i++) {
                var series = new ArrayList<Double>(len);
                for (int j = 0; j < len; j++) {
                    series.add(rand.nextDouble());
                }
                matrix.add(series);
            }
            matrices.add(matrix);
        }
    }
}
