package org.prog.testng;

import org.testng.annotations.*;

public class ParentTest {

    @BeforeSuite
    public void setUp() {
        System.out.println("======================");
        System.out.println("I start google chrome");
        System.out.println("======================");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("============================");
        System.out.println("I close google chrome driver");
        System.out.println("============================");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("---------------------------");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("------------------------------");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I load google page");
        System.out.println("I accept cookies if they are present");
    }
}
