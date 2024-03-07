package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rozetka.com.ua/ua/promo/spring_sale/?gad_source=1&gclid=CjwKCAiAopuvBhBCEiwAm8jaMdgXw80YjBrfn30x9j-oL-9NsW5l0yTNf-rq41EKiFASiNYLkyf_AhoCyykQAvD_BwE");
            WebElement result = driver.findElement(By.xpath("/html/body/app-root/rz-single-modal-window/div[3]/div[2]/rz-popup18-content/div/input"));
            result.click();
            WebElement textfield = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/div/div[1]/input"));
            textfield.sendKeys("Iphone 15");
            WebElement result1 = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/button"));
            result1.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            List<WebElement> search =
                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("rz-button-product-page"), 3));
            WebElement searchIphone =  driver.findElement(By.xpath("/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/div[1]/rz-button-product-page[1]"));
            searchIphone.click();




        }
catch (Throwable exception){System.out.println(exception.getMessage());}
        finally {
            driver.quit();
        }

    }
}
