package com.spotify.heroic.benchmarks.arithmetic.series.mxparser;

import com.spotify.heroic.benchmarks.arithmetic.series.OperatorFactory;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorType;
import java.util.function.BiFunction;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.PrimitiveElement;

public class OperatorFactoryImpl implements OperatorFactory {

    @Override
    public BiFunction<Double, Double, Double> createOperator(OperatorType operatorType) {
        Function func = null;

        switch (operatorType) {
            case ADD:
                func = new Function("f(a, b) = a + b");
                break;
            case SUB:
                func = new Function("f(a, b) = a - b");
                break;
            case MUL:
                func = new Function("f(a, b) = a * b");
                break;
            case DIV:
                func = new Function("f(a, b) = a / b");
                break;
            default:
                throw new RuntimeException("Unexpected `OperatorType`: " + operatorType.name());
        }

        return new Operator(func);
    }
}
