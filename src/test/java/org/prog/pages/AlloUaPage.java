package org.prog.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AlloUaPage {
    private final WebDriver driver;

    public AlloUaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public void searchForGoods(String searchValue) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchValue);
        searchInput.sendKeys(Keys.ENTER);
    }
    public List<WebElement> getPagination() {
      return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(
                        ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.pagination"),
                                1)
                );
    }


    public List<WebElement> getSearchResults() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(
                        ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div.product-card"),
                                1)
                );
    }

    public boolean searchResultsContain(String value) {
        List<WebElement> searchResults = getSearchResults();
        Assert.assertFalse(searchResults.isEmpty(), "Search results must not be empty!");
        boolean valueIsPresent = false;
        for (WebElement e : searchResults) {
            if (e.findElement(By.xpath("div/a")).getText().contains(value)) {
                valueIsPresent = true;
                break;
            }
        }
        return valueIsPresent;
    }
    public WebElement pagination(){
        return driver.findElement(By.className("pagination"));
    }

    public void scrollToElement(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
    }
    public void clickElement (WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
    }
    public boolean right(){
        WebElement result;
        List<WebElement> searchResults = getPagination();
        boolean isPresent = !driver.findElements(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/a")).isEmpty();
        if (isPresent) {
            result = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/a"));
            result.click();
        }
        return isPresent;
    }
    public boolean left() {
        WebElement result;
        List<WebElement> searchResults = getPagination();
        boolean isPresent = !driver.findElements(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div[1]/a")).isEmpty();
        if (isPresent) {
            result = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[3]/div[1]/a"));
            result.click();
        }
        return isPresent;
    }
    public boolean byPageNumber(int PageNum){
        List<WebElement> searchResults = getPagination();
        WebElement page = pagination();
        boolean check = false;
        List<WebElement> searchResults2 = page.findElements(By.className("pagination__list"));
        for (int i = 0; i < searchResults2.size(); i++) {
            if (searchResults2.get(i).getText().contains(String.valueOf(PageNum))){
                clickElement(searchResults2.get(i));
                check = true;
            }
        }
        if(check == false) {
            System.out.println("Not found");
        }
        return check;
    }
}


