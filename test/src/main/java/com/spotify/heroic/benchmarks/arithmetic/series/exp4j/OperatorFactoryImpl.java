package com.spotify.heroic.benchmarks.arithmetic.series.exp4j;

import com.spotify.heroic.benchmarks.arithmetic.series.Operator;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorFactory;
import com.spotify.heroic.benchmarks.arithmetic.series.OperatorType;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Map;
import java.util.Set;

public class OperatorFactoryImpl implements OperatorFactory {

  @Override
  public Operator createOperator(OperatorType operatorType) {
    switch (operatorType) {
        case ADD:
            // TODO
            var expr = new ExpressionBuilder("A + B").variables(Set.of("A", "B")).build();
//            var doop = expr.build().evaluate();
            //return new OperatorImplExp4J(expr);
            // TODO
//            return (a, b) -> { double res = a + b; };
//            final Map<String,Double> variableMap = Map.of("A", 2.345,"B",292.452);

            // plug the variables and their values into the engine and evaluate the result
//            final double result = expressionEngine.setVariables(variableMap).evaluate();

        default:
            throw new RuntimeException("KABOOM");
    }
  }
}
