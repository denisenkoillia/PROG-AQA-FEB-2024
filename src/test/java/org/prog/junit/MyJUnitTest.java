package org.prog.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MyJUnitTest extends ParentTest {

    @BeforeEach
    public void beforeTest() {
        System.out.println("-------------Before Test---------------");
        System.out.println("I load google page");
        System.out.println("I accept cookies if they are present");
        System.out.println("---------------------------------------");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    @ParameterizedTest
    @MethodSource("celebrityTestArgs2")
    public void myGoogleSearchForBen(String name) {
        System.out.println("I locate search bar and enter " + name);
        System.out.println("I perform search");
        System.out.println("I validate there are at least 3 headers in search results");
    }

    @ParameterizedTest
    @MethodSource("celebrityTestArgs")
    public void luckySearchTest(int run, String celebrityName, String pageUrl) {
        System.out.println("This is test run #" + run);
        System.out.println("I locate search bar and enter " + celebrityName);
        System.out.println("I press feeling lucky");
        System.out.println("I confirm page url is " + pageUrl + " for " + celebrityName);
    }

    private static Stream<Arguments> celebrityTestArgs() {
        return Stream.of(
                Arguments.of(1,//int run
                        "Ben Affleck",//String celebrityName
                        "wikipedia" //String pageUrl
                ),
                Arguments.of(2, "Nicolas Cage", "IMDB")
        );
    }

    private static Stream<Arguments> celebrityTestArgs2() {
        return Stream.of(
                Arguments.of("Ben Affleck"),
                Arguments.of("Sean Bean"),
                Arguments.of("Jim Carry"),
                Arguments.of("Nikole Kidman")
        );
    }

    private void runTests(){
        luckySearchTest(1, "Ben Affleck", "wikipedia");
        luckySearchTest(2, "Nicolas Cage", "IMDB");
    }
}
