package com.test;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class TestRules {

    @Rule
    public TestRule rule = new TestWatcher() {

        @Override
        protected void succeeded(Description description) {
            System.out.println("Test " + description.getMethodName() + " succeeded");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Test " + description.getMethodName() + " failed");
        }

        @Override
        protected void starting(Description description) {
            MyOwnAnnotation annotation = description.getAnnotation(MyOwnAnnotation.class);
            if (annotation != null)
                System.out.println(annotation.info());

            System.out.println("Test " + description.getMethodName() + " has started");
        }

        @Override
        protected void finished(Description description) {
            System.out.println("Test " + description.getMethodName() + " has finished\r\n");
        }
    };
}
