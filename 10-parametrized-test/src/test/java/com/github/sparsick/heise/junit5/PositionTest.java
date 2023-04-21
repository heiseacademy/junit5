package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PositionTest {


    @DisplayName("Move Backward Test")
    @ParameterizedTest (name = " {index} -> Directon {0}, {1}")
    @MethodSource
    void moveBackward(Direction input, Position output) {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(input);

        assertEquals(output, newPosition);
    }

    static Stream<Arguments> moveBackward() {
        return Stream.of(
                arguments(Direction.NORTH, new Position(10, 9)),
                arguments(Direction.EAST, new Position(9, 10)),
                arguments(Direction.SOUTH, new Position(10, 11)),
                arguments(Direction.WEST, new Position(11, 10))
        );
    }

    @ParameterizedTest
    @MethodSource
    void moveForward(Direction input, Position output) {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveForward(input);

        assertEquals(output, newPosition);
    }

    static Stream<Arguments> moveForward() {
        return Stream.of(
                arguments(Direction.NORTH, new Position(10, 11)),
                arguments(Direction.EAST, new Position(11, 10)),
                arguments(Direction.SOUTH, new Position(10, 9)),
                arguments(Direction.WEST, new Position(9, 10))
        );
    }

    @Test
    void simpleTest() {
        System.out.println("Hello Mars");
    }
}
