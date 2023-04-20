package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionNaiveTest {

    @Test
    void moveBackward_toNorth() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.NORTH);

        assertEquals(new Position(10, 9), newPosition);
    }

    @Test
    void moveBackward_toEast() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.EAST);

        assertEquals(new Position(9, 10), newPosition);
    }

    @Test
    void moveBackward_toSouth() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.SOUTH);

        assertEquals(new Position(10, 11), newPosition);
    }

    @Test
    void moveBackward_toWest() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.WEST);

        assertEquals(new Position(11, 10), newPosition);
    }
}
