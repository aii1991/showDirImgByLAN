package com.jason.test;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * Created by jason on 2017/2/21.
 */
public class Junit4ClassRunner extends SpringJUnit4ClassRunner{

    static {
        try {
            Log4jConfigurer.initLogging("classpath:config/log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

    /**
     * Constructs a new {@code SpringJUnit4ClassRunner} and initializes a
     * {@link TestContextManager} to provide Spring testing functionality to
     * standard JUnit tests.
     *
     * @param clazz the test class to be run
     * @see #createTestContextManager(Class)
     */
    public Junit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
}
