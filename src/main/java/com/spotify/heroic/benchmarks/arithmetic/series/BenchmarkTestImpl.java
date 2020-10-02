package com.spotify.heroic.benchmarks.arithmetic.series;

public class BenchmarkTestImpl implements BenchmarkTest {

    private static final int NUM_TEST_VALUES = 100;
    private final Operator op;
    private int testValueIdx;
    private double[] testValues;

    public BenchmarkTestImpl(Operator op) {
        this.op = op;
        this.testValues = new double[NUM_TEST_VALUES];
        populateTestValues();
    }

    private void populateTestValues() {
        for(int i = 0; i < NUM_TEST_VALUES; i++) {
            testValues[i] = (double)i;
        }
    }

    private double getNextTestValue() {
        return testValues[testValueIdx++ % NUM_TEST_VALUES];
    }

    @Override
    public double testSimpleExpressionWithNSeries(BenchmarkState state) {
        return op.apply(getNextTestValue(), getNextTestValue());
    }
}
