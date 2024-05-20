package org.example.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void getAndroidDriver() {
         DriverManager.getInstance().getDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.getInstance().quitDriver();
    }
}
