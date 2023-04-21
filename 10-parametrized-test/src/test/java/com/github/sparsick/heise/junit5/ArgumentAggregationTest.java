package com.github.sparsick.heise.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ArgumentAggregationTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    void heroList (ArgumentsAccessor arguments) {
        System.out.println(arguments.getInteger(0) + " " + arguments.getString(1) + " " + arguments.getString(2) + " " + arguments.getString(3));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    void heroAggregatorList (@AggregateWith(HeroAggregator.class) Hero hero) {
        System.out.println(hero);
    }
}

