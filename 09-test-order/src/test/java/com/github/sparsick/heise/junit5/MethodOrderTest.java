package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTest {


    //MethodOrderer.DisplayName
    //MethodOrderer.MethodName
    //MethodOrderer.OrderAnnotation
    //MethodOrderer.Random

    @Test
    @Order(1)
    void prepare(){
        System.out.println("Prepare!");
    }


    @Test
    @Order(2)
    void run(){
        System.out.println("Run!");
    }

    @Test
    @Order(3)
    void evaluate() {
        System.out.println("Evaluate!");
    }

    @Test
    @Order(4)
    void someStuff() {
        System.out.println("someStuff!");
    }
}
