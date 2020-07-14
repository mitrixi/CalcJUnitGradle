package com.test;

import com.test.interfaces.ParametrizedTests;
import com.test.interfaces.UsualTests;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class CalcTest extends TestRules {
    private static Calc calc;

    @BeforeClass
    public static void createCalc() {
        calc = new Calc();
    }



    @Category(UsualTests.class)
    @Test
    public void shouldReturnSumOfTwoNumbers() {
        assertThat(calc.sum(5, 5), equalTo(10));
    }

    @Category({UsualTests.class, ParametrizedTests.class})
    @Test
    @UseDataProvider(value = "dataProviderSumArray", location = DataProvider.class)
    public void shouldReturnSumOfArrayNumber(int expected, int... varargs) {
        assertEquals(expected, calc.sumVarArgs(varargs));
    }

    @Category(UsualTests.class)
    @Test
    public void shouldReturnDiffOfTwoNumbers() {
        assertThat(calc.subtracting(10, 15), equalTo(-5));
    }

//    @com.test.MyOwnAnnotation(info = "1")
    @Category({UsualTests.class, ParametrizedTests.class})
    @Test
    @UseDataProvider(value = "dataProviderMul", location = DataProvider.class)
    public void shouldReturnMultiplicationOfTwoNumbers(int a, int b, int expected) {
        assertEquals(expected, calc.multiplication(a, b));
    }
//    @com.test.MyOwnAnnotation(info = "2")
    @Category({UsualTests.class, ParametrizedTests.class})
    @Test
    @UseDataProvider(value = "dataProviderDiv", location = DataProvider.class)
    public void shouldReturnDivisionOfTwoNumbers(int a, int b, int expected) {
        assertEquals(expected, calc.division(a, b));
    }

}

