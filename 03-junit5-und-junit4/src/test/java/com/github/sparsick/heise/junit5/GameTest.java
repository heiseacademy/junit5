package com.github.sparsick.heise.junit5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 *
 */
public class GameTest {

    @Test
    public void roll_twelveStrikes() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("XXXXXXXXXXXX");

        assertEquals(300, totalSum);
    }

    @Test
    public void roll_twentiesRollsWithtenMisses() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("9-9-9-9-9-9-9-9-9-9-");

        assertEquals(90, totalSum);
    }
    
    @Test
    public void roll_twentyOneRollsWithTenSpares() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("5/5/5/5/5/5/5/5/5/5/5");

        assertEquals(150, totalSum);
    }

}
