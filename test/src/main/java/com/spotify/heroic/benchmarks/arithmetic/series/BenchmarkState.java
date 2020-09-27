package com.spotify.heroic.benchmarks.arithmetic.series;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Map;
import java.util.Set;

@State(Scope.Benchmark)
public class BenchmarkState {
    // NOTE: these do not need to be volatile cos they're not mutated once
    // the tests have started running.
    public static Expression expression;
    public static Map<String, Double> datum;

    public static Set<Integer> SERIES_LENGTHS = Set.of(1, 10, 100, 500, 4_000, 4_000_000);
    public static Set<Integer> SERIES_COUNTS = Set.of(1, 10, 100, 500, 4_000);
    public static Map<Integer, Integer> THE_SERIES;

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

    @Setup
    public void setup() {
        // build matrices defs
        for (int len : SERIES_LENGTHS) {
            for (int count : SERIES_COUNTS) {

            }
        }

        // build matrices
//        TODO
    }
}
