package org.example.config;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Platform;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {

    public static URL getAppiumServerURL() throws MalformedURLException {
        return new URL("http://127.0.0.1:4723/wd/hub");
    }

    public static UiAutomator2Options getAndroidOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        Path path = Paths.get("Demo.apk");
        options.autoGrantPermissions();
        options.noReset();
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformVersion("14");
        options.setPlatformName(Platform.ANDROID.name());
        options.setApp(path.toAbsolutePath().toString());
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppWaitForLaunch(true);
        return options;
    }
}

