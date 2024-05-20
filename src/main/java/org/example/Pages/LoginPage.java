package org.example.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    private AndroidDriver driver;


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement userName;

    @AndroidFindBy(accessibility = "test-Password")
    private WebElement password;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    private WebElement incorrectLoginText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    private WebElement optionButton;

    @AndroidFindBy(accessibility = "test-LOGOUT")
    private WebElement logOutButton;

    public WebElement getUserName(){
        return userName;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getLoginButton(){
        return loginButton;
    }

    public WebElement getIncorrectLoginText(){
        return incorrectLoginText;
    }

    public WebElement getOptionButton(){
        return optionButton;
    }

    public WebElement getLogOutButton(){
        return logOutButton;
    }

}
