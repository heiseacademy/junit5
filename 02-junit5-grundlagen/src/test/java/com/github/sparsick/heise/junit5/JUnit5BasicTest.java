package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5BasicTest {

    @BeforeAll
    static void setUpAll() {
        System.out.println("Setup before all Tests");

    }

    @BeforeEach
    void setup() {
        System.out.println("Setup before each Test");

    }

    @Disabled
    @Test
    void simpleTestMethod(){
        System.out.println("A simple Test!");
    }

    @Test
    void secondSimpleTestMethod(){
        System.out.println("A second simple Test!");
        assertTrue(true);
        assertEquals(1,1);
        assertNull(null);
    }

    @AfterEach
    void teardown() {
        System.out.println("Teardown after each Test");
    }

    @AfterAll
    static void teardownAll() {
        System.out.println("Teardown after all Tests");

    }

}
