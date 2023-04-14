package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ConditionalTestExecutionTest {

    @Disabled
    @Test
    void simpleTest(){
        System.out.println("This is a simple test");
    }

    // Operating System Condition

    // Operating System Architecture Conditions

    // Java Runtime Environment Conditions

    // Native Image Conditions

    // System Property Conditions

    // Environment Variable Conditions

    // Custom Conditions
}
