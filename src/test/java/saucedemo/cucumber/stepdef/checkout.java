package saucedemo.cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkout {
    WebDriver driver;
    String baseurl = "http://saucedemo.com";

    public void login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseurl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Given("product page")
    public void product_page(){
        login();
    }

    @When("click the button add to cart")
    public void clickTheButtonAddToCart() throws Exception {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }

    @And("click iconcart")
    public void clickIconcart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("click checkout button")
    public void clickCheckoutButton() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("show checkout page")
    public void showCheckoutPage() {
        Assert.assertEquals("Checkout: Your Information",driver.findElement(By.xpath("//span[@class='title']")).getText());
        System.out.println("Show Checkout Page one Success");
    }

    @And("input buyer data")
    public void inputBuyerData() {
        driver.findElement(By.id("first-name")).sendKeys("lionel");
        driver.findElement(By.id("last-name")).sendKeys("messi");
        driver.findElement(By.id("postal-code")).sendKeys("54321");
        driver.findElement(By.id("continue")).click();
    }

    @Then("show checkout preview")
    public void showCheckoutPreview() {
        Assert.assertEquals("Checkout: Overview",driver.findElement(By.xpath("//span[@class='title']")).getText());
        System.out.println("Show Checkout preview Page Success");
    }

    @And("click finish button")
    public void clickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("finish")
    public void finish() {
        Assert.assertEquals("Checkout: Complete!",driver.findElement(By.xpath("//span[@class='title']")).getText());
        System.out.println("Checkout Success");
    }
}
