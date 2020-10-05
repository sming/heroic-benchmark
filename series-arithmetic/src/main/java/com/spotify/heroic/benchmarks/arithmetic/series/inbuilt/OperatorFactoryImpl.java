package com.spotify.heroic.benchmarks.arithmetic.series.inbuilt;

import com.spotify.heroic.benchmarks.arithmetic.series.OperatorFactory;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorType;
import java.util.function.BiFunction;

public class OperatorFactoryImpl implements OperatorFactory {

  @SuppressWarnings("CheckStyle")
  @Override
  public BiFunction<Double, Double, Double> createOperator(OperatorType operatorType) {
    switch (operatorType) {
        case ADD:
            return (a, b) -> { return a + b; };
        case SUB:
            return (a, b) -> { return a - b; };
        case MUL:
            return (a, b) -> { return a * b; };
        case DIV:
            return (a, b) -> { return a / b; };
        default:
            throw new RuntimeException("KABOOM");
    }
  }
}
