package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 *
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameTest {

    @Test
    void roll_twelve_strikes() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("XXXXXXXXXXXX");

        assertEquals(300, totalSum);
    }

    @Test
    void roll_twentiesRollsWithtenMisses() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("9-9-9-9-9-9-9-9-9-9-");

        assertEquals(90, totalSum);
    }

    @Test
    void roll_twentyOneRollsWithTenSpares() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("5/5/5/5/5/5/5/5/5/5/5");

        assertEquals(150, totalSum);
    }

}
