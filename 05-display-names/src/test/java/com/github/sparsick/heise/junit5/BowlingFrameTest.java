package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 *
 */
class BowlingFrameTest {

    @Test
    void totalSum_failToKnockAll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("1");
        frameUnderTest.roll("1");

        int totalSum = frameUnderTest.totalSum();

        assertEquals(2, totalSum);
    }

    @Test
    void totalSum_secondFailToKnockAll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("2");
        frameUnderTest.roll("2");

        int totalSum = frameUnderTest.totalSum();

        assertEquals(4, totalSum);
    }

    @Test
    void totalSum_failToKnockAllWithAMissAsFirstRoll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("-");
        frameUnderTest.roll("1");

        int totalSum = frameUnderTest.totalSum();

        assertEquals(1, totalSum);
    }

    @Test
    void totalSum_failToKnockAllWithTwoMissedRoll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("-");
        frameUnderTest.roll("-");

        int totalSum = frameUnderTest.totalSum();

        assertEquals(0, totalSum);
    }

    @Test
    void totalSum_strike() {
        BowlingFrame nextBowlingFrame = new BowlingFrame();
        nextBowlingFrame.roll("1");
        nextBowlingFrame.roll("1");
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("X");
        frameUnderTest.nextFrame(nextBowlingFrame);

        int totalSum = frameUnderTest.totalSum();

        assertEquals(12, totalSum);
    }

    @Test
    void totalSum_twoStrike() {
        BowlingFrame lastBowlingFrame = new BowlingFrame();
        lastBowlingFrame.roll("1");
        lastBowlingFrame.roll("1");
        BowlingFrame nextFrameWithStrike = new BowlingFrame();
        nextFrameWithStrike.roll("X");
        nextFrameWithStrike.nextFrame(lastBowlingFrame);
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("X");
        frameUnderTest.nextFrame(nextFrameWithStrike);

        int totalSum = frameUnderTest.totalSum();

        assertEquals(21, totalSum);
    }

    @Test
    void totalSum_spare() {
        BowlingFrame nextBowlingFrame = new BowlingFrame();
        nextBowlingFrame.roll("1");
        nextBowlingFrame.roll("1");
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("3");
        frameUnderTest.roll("/");
        frameUnderTest.nextFrame(nextBowlingFrame);

        int totalSum = frameUnderTest.totalSum();

        assertEquals(11, totalSum);
    }



}
