package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;

public class Main {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        new ChromeGoogleTest().chromeTest();
    }
}