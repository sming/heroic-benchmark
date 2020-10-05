package com.spotify.heroic.benchmarks.arithmetic.series.mxparser;

import java.util.function.BiFunction;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

public class Operator implements BiFunction<Double, Double, Double> {
    Function func = null;

    public Operator(Function func) {
        this.func = func;
    }

    /**
     * Applies this function to the given arguments.
     *
     * @param aDouble  the first function argument
     * @param aDouble2 the second function argument
     * @return the function result
     */
    @Override
    public Double apply(Double a, Double b) {
        func.setArgumentValue(0, a);
        func.setArgumentValue(1, b);
        return func.calculate();
    }
}
