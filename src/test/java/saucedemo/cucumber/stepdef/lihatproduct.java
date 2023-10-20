package saucedemo.cucumber.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lihatproduct {
    WebDriver driver;
    String baseurl = "http://saucedemo.com";
    public void login(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Given("inventory page")
    public void inventory_page(){
        login();
    }

    @When("choose product")
    public void chooseProduct() {
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")).click();
    }

    @Then("user in detail product")
    public void userInDetailProduct() {
        Assert.assertEquals("Sauce Labs Bike Light",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario Show Detail Product Success");
    }


}
