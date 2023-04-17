package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("benchmarkDemo")
public class TaggedTest {

    @Test
    void simpleTest(){
        System.out.println("A simple test");
    }


    @Test
    @Tag("benchmark")
    void benchmarkTest(){
        System.out.println("A benchmark test");
    }

    @Test
    @Tags({@Tag("benchmark"), @Tag("slow")})
    void slowBenchmarkTest() {
        System.out.println("A slow benchmark test");
    }

    @Test
    @Benchmark
    void ownBenchmarkAnnotationTest() {
        System.out.println("A benchmark test with custom annotation");
    }

}
