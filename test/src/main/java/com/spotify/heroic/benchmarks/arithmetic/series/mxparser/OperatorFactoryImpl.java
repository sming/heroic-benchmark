package com.spotify.heroic.benchmarks.arithmetic.series.mxparser;

import com.spotify.heroic.benchmarks.arithmetic.series.Operator;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorFactory;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorType;
import java.util.Map;
import java.util.Set;
import org.mariuszgromada.math.mxparser.*;

public class OperatorFactoryImpl implements OperatorFactory {

    @Override
    public Operator createOperator(OperatorType operatorType) {
        Function func = null;
        switch (operatorType) {
            case ADD:
                func = new Function("A / B * 100");
                break;
            case SUB:
                func = new Function("A - B * 100");
                break;
            case MUL:
                func = new Function("A / B * 100");
                break;
            case DIV:
                func = new Function("A / B * 100");
                break;
            default:
                throw new RuntimeException("KABOOM");
        }

        return new com.spotify.heroic.benchmarks.arithmetic.series.mxparser.Operator(func);
    }
}
