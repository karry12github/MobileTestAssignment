package stepDefinition;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.LoginPage;
import org.example.Pages.ProductsPage;
import org.example.config.ConfigUtil;
import org.example.utils.DriverManager;
import org.example.utils.Utils;
import org.junit.Assert;

public class MyStepdefs {

    AndroidDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;


    @Given("the app is launched")
    public void theAppIsLaunched() {
        driver = DriverManager.getInstance().getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }


    @And("Login with valid credentials")
    public void loginAndLoginToApp() throws InterruptedException {
        Thread.sleep(10000);
        loginPage.getUserName().sendKeys(ConfigUtil.getProperty("username"));
        loginPage.getPassword().sendKeys(ConfigUtil.getProperty("password"));
        Utils.waitForElementToBeVisible(driver,loginPage.getLoginButton(),10000);
        loginPage.getLoginButton().click();

    }

    @And("Login with invalid credentials")
    public void loginAndLoginToAppWithInvalidCred() throws InterruptedException {
        Thread.sleep(10000);
        loginPage.getUserName().sendKeys(ConfigUtil.getProperty("invalidUsername"));
        loginPage.getPassword().sendKeys(ConfigUtil.getProperty("invalidPassword"));
        Utils.waitForElementToBeVisible(driver,loginPage.getLoginButton(),10000);
        loginPage.getLoginButton().click();

    }

    @And("Validate the homePage of the mobileApp")
    public void validateTheHomePageOfTheMobileApp() throws InterruptedException {
        Assert.assertEquals("PRODUCTS",productsPage.getProductsHomePage().getText());

    }

    @Then("validate the error message {string}")
    public void validateErrorMessage(String incorrectTextToValidate){
        String incorrectLoginText = loginPage.getIncorrectLoginText().getText();
        Assert.assertEquals(incorrectTextToValidate,incorrectLoginText);

    }

    @Then("get the count of number of products and validate if it is equal to {int}")
    public void validateProductsCount(int prodCount){

        int productsCount = productsPage.getProductsCount().size();
        Assert.assertEquals("Products count is not equal",prodCount,productsCount);
    }


    @Then("Logout of the App")
    public void logoutOfTheApp() throws InterruptedException {

        loginPage.getOptionButton().click();
        Thread.sleep(10000);
        Utils.waitForElementToBeVisible(driver,loginPage.getLogOutButton(),10000);
        loginPage.getLogOutButton().click();
    }
}
