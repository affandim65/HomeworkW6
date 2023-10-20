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

public class addCart {
    WebDriver driver;
    String baseurl = "http://saucedemo.com";

    public void login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseurl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    
    @Given("list product page")
    public void list_product_page(){
        login();
    }

    @When("click button add to cart")
    public void clickButtonAddToCart()throws Exception {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        //Thread.sleep(500);
    }

    @And("click cart icon")
    public void clickCartIcon() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

    }

    @Then("cart page show the choosen product")
    public void cartPageShowTheChoosenProduct() {
        Assert.assertEquals("Sauce Labs Bike Light",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario Adding To Cart Success");
    }
}
