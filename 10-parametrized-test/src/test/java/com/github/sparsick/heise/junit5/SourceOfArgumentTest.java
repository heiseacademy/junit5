package com.github.sparsick.heise.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SourceOfArgumentTest {
    //    @ValueSource
    @ParameterizedTest
    @ValueSource(strings = {"mars", "earth"})
    void simpleValueTest(String input) {
        assertNotNull(input);
    }

    //    Null and Empty Sources
    @ParameterizedTest
    @NullSource
    @EmptySource
//    @NullAndEmptySource
    @ValueSource(strings = {"\t", "\n"})
    void nullAndEmptyTest(String input) {
        assertTrue(input == null || input.trim().isEmpty());
    }

//    @EnumSource
    @ParameterizedTest
    @EnumSource
    void directionTest(Direction input) {
        assertNotNull(input);
    }

    @ParameterizedTest
    @EnumSource(names = {"NORTH", "SOUTH"})
    void directionIncludesTest(Direction input) {
        assertTrue(EnumSet.of(Direction.NORTH, Direction.SOUTH).contains(input));
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"WEST", "EAST"})
    void directionExcludeTest(Direction input) {
        assertTrue(EnumSet.of(Direction.NORTH, Direction.SOUTH).contains(input));
    }
//    @MethodSource


    @ParameterizedTest
    @MethodSource
    void stringMethodSourceTest(String input) {
        assertNotNull(input);
    }

    static Stream<String> stringMethodSourceTest() {
        return Stream.of("Mars", "Earth");
    }

    @ParameterizedTest
    @MethodSource
    void calculatePlusOne (int input, int output) {
        assertEquals(output, ++input);
    }

    static Stream<Arguments> calculatePlusOne () {
        return Stream.of(Arguments.arguments(1, 2), Arguments.arguments(2,3));
    }

//    @CsvSource

    @ParameterizedTest
    @CsvSource({
            "1,2",
            "2,3"
    })
    void calculatePlusOneCsv(int input, int output) {
        assertEquals(output, ++input);
    }
//    @CsvFileSource
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    void heroList (int id, String name, String vorname, String stadt) {
        System.out.println(id + " " + name + " " + vorname + " " + stadt);
    }

//    @ArgumentsSource
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void argumentProvider(String input) {
        assertNotNull(input);
    }

}
