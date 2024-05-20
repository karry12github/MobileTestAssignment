package org.example.Pages;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(10000)),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private WebElement productsHomePage;

    public WebElement getProductsHomePage(){
        return productsHomePage;
    }

    public List<WebElement> getProductsCount(){
        return driver.findElements(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]"));
    }

}
