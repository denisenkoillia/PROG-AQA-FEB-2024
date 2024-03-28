package org.prog.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.pages.AlloUaPage;
import org.prog.web.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class AlloUaTest {

    private final WebDriver driver = WebDriverFactory.getDriver();
    private AlloUaPage page;

    @BeforeSuite
    public void setUp() {
        page = new AlloUaPage(driver);
        page.loadPage();
    }

    //TODO: add method to page object that will switch between search pages
    //TODO: methods: left, right and by page number
    //TODO: test must vefiry that searched value is present on that page
    @Test
    public void searchForPhone() {
        String phoneName = "iPhone 15";
        page.searchForGoods(phoneName);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on page");
        page.scrollToElement(page.pagination());
        Assert.assertTrue(page.right()," Not found page Right");
        // add verifiation like line 29
    }

    //TODO: add second test where you change page by clicking "2"

    //TODO: * - switch page "2" then click "<" then validate goods
    @Test
    public void searchByPageNum() {
        String phoneName = "iPhone 15";
        page.searchForGoods(phoneName);
        List<WebElement> searchResults = page.getPagination();
        page.scrollToElement(page.pagination());
        page.searchForGoods(phoneName);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on page");

    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}