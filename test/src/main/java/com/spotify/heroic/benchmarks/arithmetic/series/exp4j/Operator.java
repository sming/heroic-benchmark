package com.spotify.heroic.benchmarks.arithmetic.series.exp4j;

import net.objecthunter.exp4j.Expression;
import java.util.Map;

public class Operator implements com.spotify.heroic.benchmarks.arithmetic.series.Operator {

    private final Expression expr;

    public Operator(Expression expr) {
        this.expr = expr;
    }

    @Override
    public double apply(double a, double b) {
        return expr.setVariables(Map.of("A", a, "B", b)).evaluate();
    }
}
