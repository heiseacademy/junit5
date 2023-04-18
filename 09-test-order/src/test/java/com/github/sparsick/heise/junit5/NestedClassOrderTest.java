package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;


@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class NestedClassOrderTest {

    @Nested
    @Order(1)
    class PrepareTest{
        @Test
        void prepare(){
            System.out.println("Prepare!");
        }
    }

    @Nested
    @Order(2)
    class RunTest{
        @Test
        void run(){
            System.out.println("Run!");
        }

    }

    @Nested
    @Order(3)
    class EvaluateTest{
        @Test
        void evaluate() {
            System.out.println("Evaluate!");
        }
    }
}
