package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedClassOrderTest {

    @Nested
    class PrepareTest{
        @Test
        void prepare(){
            System.out.println("Prepare!");
        }
    }

    @Nested
    class RunTest{
        @Test
        void run(){
            System.out.println("Run!");
        }

    }

    @Nested
    class EvaluateTest{
        @Test
        void evaluate() {
            System.out.println("Evaluate!");
        }
    }
}
