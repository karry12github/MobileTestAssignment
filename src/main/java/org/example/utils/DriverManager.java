package org.example.utils;


import io.appium.java_client.android.AndroidDriver;
import org.example.config.Config;

public class DriverManager {
    private static DriverManager instance = null;
    private AndroidDriver driver;

    private DriverManager() {
        // Private constructor to prevent instantiation
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    public
    AndroidDriver getDriver() {
        if (driver == null) {
            try {

                driver = new AndroidDriver(Config.getAppiumServerURL(), Config.getAndroidOptions());;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

