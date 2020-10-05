package com.spotify.heroic.benchmarks.arithmetic.series.exp4j;

import com.spotify.heroic.benchmarks.arithmetic.series.OperatorFactory;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorType;
import java.util.Set;
import java.util.function.BiFunction;
import net.objecthunter.exp4j.ExpressionBuilder;

public class OperatorFactoryImpl implements OperatorFactory {

  @Override
  public BiFunction<Double, Double, Double> createOperator(OperatorType operatorType) {
      final ExpressionBuilder builder;
          switch (operatorType) {
              case ADD:
                  builder = new ExpressionBuilder("A + B");
                  break;
              case SUB:
                  builder = new ExpressionBuilder("A - B");
                  break;
              case MUL:
                  builder = new ExpressionBuilder("A * B");
                  break;
              case DIV:
                  builder = new ExpressionBuilder("A / B");
                  break;
        default:
            throw new RuntimeException("KABOOM");
          }

      return new Operator(builder.variables(Set.of("A", "B")).build());
  }
}
