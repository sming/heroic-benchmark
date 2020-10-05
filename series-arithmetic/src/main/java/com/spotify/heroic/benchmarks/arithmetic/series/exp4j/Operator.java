package com.spotify.heroic.benchmarks.arithmetic.series.exp4j;

import java.util.function.BiFunction;
import net.objecthunter.exp4j.Expression;
import java.util.Map;

public class Operator implements BiFunction<Double, Double, Double> {

    private final Expression expr;

    public Operator(Expression expr) {
        this.expr = expr;
    }

    @Override
    public Double apply(Double a, Double b) {
        return expr.setVariables(Map.of("A", a, "B", b)).evaluate();
    }
}
