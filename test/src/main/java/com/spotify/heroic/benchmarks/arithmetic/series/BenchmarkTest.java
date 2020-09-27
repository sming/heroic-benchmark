package com.spotify.heroic.benchmarks.arithmetic.series;

public interface BenchmarkTest {
    void testDivisionWithNSeries(BenchmarkState state);
    void testMultiplicationWithNSeries(BenchmarkState state);
    void testSubtractionWithNSeries(BenchmarkState state);
    void testAdditionWithNSeries(BenchmarkState state);
    void testCompoundExpression1WithNSeries(BenchmarkState state);
    void testCompoundExpression2WithNSeries(BenchmarkState state);
    void testCompoundExpression3WithNSeries(BenchmarkState state);

}
