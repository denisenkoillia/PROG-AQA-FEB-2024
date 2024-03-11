package org.prog.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MyJUnitTest2 extends ParentTest {

    @ParameterizedTest
    @EnumSource(EnumValues.class)
    public void myFirstTest4(EnumValues value) {
        System.out.println(value.name());
    }

    @ParameterizedTest
    @ValueSource(strings = {"value_1", "value_2"})
    public void myFirstTest5(String parameter) {
        System.out.println(parameter);
    }
}
