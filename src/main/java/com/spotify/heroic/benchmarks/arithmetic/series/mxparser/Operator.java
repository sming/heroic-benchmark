package com.spotify.heroic.benchmarks.arithmetic.series.mxparser;

import org.mariuszgromada.math.mxparser.Function;
import java.util.ArrayList;
import java.util.Arrays;

public class Operator implements com.spotify.heroic.benchmarks.arithmetic.series.Operator {

    private final Function func;

    public Operator(Function func) {
        this.func = func;
    }

    @Override
    public double apply(double a, double b) {
        return func.calculate(a, b);
    }
}
