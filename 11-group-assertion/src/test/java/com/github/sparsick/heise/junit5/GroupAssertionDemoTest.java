package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAssertionDemoTest {

    @Test
    void assertionTest() {

        assertTrue(true);
        assertNull(null);
        assertFalse(false);
    }
}
