package com.test;

import com.test.interfaces.UsualTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(UsualTests.class)
@Suite.SuiteClasses({CalcTest.class})
public class ClientTest {

}