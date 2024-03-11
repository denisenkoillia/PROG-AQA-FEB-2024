package org.prog.junit;

import org.junit.jupiter.api.*;

public class ParentTest {

    @BeforeAll
    public static void setUp() {
        System.out.println("======================");
        System.out.println("I start google chrome");
        System.out.println("======================");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("============================");
        System.out.println("I close google chrome driver");
        System.out.println("============================");
    }
}
