package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.Test;


public class MethodOrderTest {


    //MethodOrderer.DisplayName
    //MethodOrderer.MethodName
    //MethodOrderer.OrderAnnotation
    //MethodOrderer.Random

    @Test
    void prepare(){
        System.out.println("Prepare!");
    }


    @Test
    void run(){
        System.out.println("Run!");
    }

    @Test
    void evaluate() {
        System.out.println("Evaluate!");
    }


}
