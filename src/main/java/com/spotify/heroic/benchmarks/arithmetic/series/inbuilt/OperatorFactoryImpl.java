package com.spotify.heroic.benchmarks.arithmetic.series.inbuilt;

import com.spotify.heroic.benchmarks.arithmetic.series.Operator;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorFactory;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorType;

public class OperatorFactoryImpl implements OperatorFactory {

  @Override
  public Operator createOperator(OperatorType operatorType) {
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
