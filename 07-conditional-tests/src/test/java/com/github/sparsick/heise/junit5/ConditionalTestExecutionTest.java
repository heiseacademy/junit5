package com.github.sparsick.heise.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledInNativeImage;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledInNativeImage;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTestExecutionTest {

    @Disabled
    @Test
    void simpleTest(){
        System.out.println("This is a simple test");
    }

    // Operating System Condition
    @Test
    @EnabledOnOs(OS.LINUX)
    void testRunOnlyOnLinux(){
        System.out.println("Linux");
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testRunOnLinuxAndMac(){
        System.out.println("Linux and Mac!");
    }

    @Test
    @DisabledOnOs({OS.LINUX, OS.MAC})
    void testRunNotOnLinuxAndMac(){
        System.out.println("Not Linux or Mac!");
    }

    // Operating System Architecture Conditions
    @Test
    @EnabledOnOs(architectures = "amd64")
    void testRunOnlyOnAmd64(){
        System.out.println("Linux amd64");
    }

    @Test
    @DisabledOnOs(architectures = "amd64")
    void testRunNotOnAmd64(){
        System.out.println("No amd64");
    }

    // Java Runtime Environment Conditions
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void runsOnJava8(){
        System.out.println("Java 8");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void runsNotOnJava8(){
        System.out.println("No Java 8");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9)
    void runsMinJava9(){
        System.out.println("minimum Java 9");
    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_9)
    void runsMaxJava9(){
        System.out.println("maximum Java 9");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_10, max=JRE.JAVA_11)
    void runsBetweenJava10And11(){
        System.out.println("between Java 10 and Java 11");
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_10, max=JRE.JAVA_11)
    void runsNotBetweenJava10And11(){
        System.out.println("Not between Java 10 and Java 11");
    }

    // Native Image Conditions
    @Test
    @EnabledInNativeImage
    void runOnlyOnGraalVM(){

    }

    @Test
    @DisabledInNativeImage
    void runNotOnGraalVM(){

    }

    // System Property Conditions

//    @BeforeEach
//    void setUp() {
//        System.setProperty("ci-server", "true");
//    }

    @Test
    @EnabledIfSystemProperty(named ="ci-server", matches = "true")
    void runOnlyOnCi(){
        System.out.println("Run on CI");
    }

    @Test
    @DisabledIfSystemProperty(named ="ci-server", matches = "true")
    void runNotOnCi(){
        System.out.println("Does not run on CI");
    }

    // Environment Variable Conditions

    @Test
    @EnabledIfEnvironmentVariable(named ="CI", matches = "true")
    void runOnlyOnCiENV(){
        System.out.println("Run on CI ENV");
    }

    @Test
    @DisabledIfEnvironmentVariable(named ="CI", matches = "true")
    void runNotOnCiENV(){
        System.out.println("Does not run on CI ENV");
    }


    // Custom Conditions
    @Test
    @EnabledIf("customCondition")
    void customConditionEnabledTest(){
        System.out.println("Custom condition enabled");
    }

    @Test
    @DisabledIf("customCondition")
    void customConditionDisabledTest(){
        System.out.println("Custom condition disabled");
    }

    boolean customCondition(){
        return false;
    }
}
