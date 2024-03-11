package org.prog.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MyTestNGTest2 extends ParentTest {

    @Test
    public void mySeleniumCode() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://google.com/");
            //accept cookies if they are present
            //find all buttons in cookies form
            List<WebElement> cookieButtons =
                    driver.findElements(By.xpath(
                            "//a[contains(@href,'https://policies.google.com/technologies/cookies')]/../../../..//button"));
            if (!cookieButtons.isEmpty()) {
                //click button with index 3 (this button accepts all cookies)
                cookieButtons.get(3).click();
            }
            //TODO: sreach for ben Affleck
            //Step 1: set search form value to Ben Affleck
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys("Ben Affleck");
            //Step 2: press enter while in search form
            searchInput.sendKeys(Keys.ENTER);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
            List<WebElement> searchHeaders =
                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("h3"), 5));

            System.out.println(">>>>> " + searchHeaders.size());

            int afflecksFound = 0;
            for (WebElement element : searchHeaders) {
                if (element.getText().contains("Ben Affleck")) {
                    afflecksFound++;
                }
            }
            if (afflecksFound >= 3) {
                System.out.println("Ben found!");
            } else {
                System.out.println("Ben not found :(");
            }
        } finally {
            driver.quit();
        }
    }
}
