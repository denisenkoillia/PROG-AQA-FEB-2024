package org.prog.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {

    private final static String s = "s";

    @Test
    public void okTest() {
        Assert.assertEquals(s, "s");
    }

    @Test
    public void failingAssertTest() {
        Assert.assertEquals(s, "a");
    }

    @Test
    public void failingExceptionTest() {
        String s1 = null;
        System.out.println(s1.length());
        Assert.assertEquals(s, "a");
    }
}
