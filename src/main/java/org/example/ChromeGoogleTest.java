package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeGoogleTest {

    @Test
    public void chromeTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                /* Get the device udid by running `adb devices` */
                .setUdid("emulator-5554")
                .withBrowserName("chrome")
                .noReset();

        /* Start appium on console */
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://www.google.com");
        driver.context("NATIVE_APP");

        /* Remove the terms and conditions pop up */
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.Button[@text='Leer más']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.Button[@text=\"Aceptar todo\"]"))).click();

        /* Search for Hello, World! */
        String searchBarXpath = "//android.webkit.WebView[@text=\"Google\"]/android.view.View"
                + "/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]"
                + "/android.view.View[1]/android.widget.EditText";
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath(searchBarXpath))).sendKeys("Hello, World!");

        assert wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(searchBarXpath),
                "Hello, World!")) : "Text not found in search bar!";
        driver.quit();
    }
}
