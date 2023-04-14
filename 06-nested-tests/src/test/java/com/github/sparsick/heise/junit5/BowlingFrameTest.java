package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 *
 */
@DisplayName("Bowling Frame")
class BowlingFrameTest {

    @Nested
    @DisplayName("Berechne die Gesamtsumme")
    class TotalSum {
        @Test
        @DisplayName("wenn nicht alle Pins umgefallen sind")
        void failToKnockAll() {
            BowlingFrame frameUnderTest = new BowlingFrame();
            frameUnderTest.roll("1");
            frameUnderTest.roll("1");

            int totalSum = frameUnderTest.totalSum();

            assertEquals(2, totalSum);
        }

        @Test
        void secondFailToKnockAll() {
            BowlingFrame frameUnderTest = new BowlingFrame();
            frameUnderTest.roll("2");
            frameUnderTest.roll("2");

            int totalSum = frameUnderTest.totalSum();

            assertEquals(4, totalSum);
        }

        @Test
        void failToKnockAllWithAMissAsFirstRoll() {
            BowlingFrame frameUnderTest = new BowlingFrame();
            frameUnderTest.roll("-");
            frameUnderTest.roll("1");

            int totalSum = frameUnderTest.totalSum();

            assertEquals(1, totalSum);
        }

        @Test
        void failToKnockAllWithTwoMissedRoll() {
            BowlingFrame frameUnderTest = new BowlingFrame();
            frameUnderTest.roll("-");
            frameUnderTest.roll("-");

            int totalSum = frameUnderTest.totalSum();

            assertEquals(0, totalSum);
        }

        @Test
        void strike() {
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
        void twoStrike() {
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
        void spare() {
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
    
    @Nested
    @IndicativeSentencesGeneration(separator = ",", generator = DisplayNameGenerator.ReplaceUnderscores.class)
    class Erkennung_eines_Strikes {
        @Test
        void wenn_alle_pins_umgeworfen_wurden(){
            BowlingFrame frameUnderTest = new BowlingFrame();
            frameUnderTest.roll("X");

            assertTrue(frameUnderTest.isStrike());
        }

        @Test
        void wenn_nicht_alle_pins_umgeworfen_wurden(){
            BowlingFrame frameUnderTest = new BowlingFrame();
            frameUnderTest.roll("3");

            assertFalse(frameUnderTest.isStrike());
        }   
    }
}
