package saucedemo.cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String baseurl = "http://saucedemo.com";

    @Given("halaman login sauce demo")
    public void halaman_login_sauce_demo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseurl);
    }

    @When("input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void clickLoginButton() {
        WebElement tombol_login = driver.findElement(By.id("login-button"));
        tombol_login.click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user in inventory page")
    public void userInInventoryPage() {
        //assertion kata product di inventory
        //driver.wait(180);
        String judulInventory = driver.findElement(By.xpath("//*[@id=\'header_container\']/div[2]/span")).getText();
        Assert.assertEquals(judulInventory, "Products");
        driver.close();
        driver.quit();
    }

    @And("input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("2345");
    }

    @Then("show error message")
    public void showErrorMessage() {
        //WebElement elemenError = driver.findElement(By.cssSelector(".error-message-container.error"));
        //assert(elemenError.getText().contains(errormessage));
        //driver.close();
        //driver.quit();

        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        System.out.println("Skenario negatif test");
        System.out.println("Gagal login karena tampil " + driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        //driver.quit();
    }


}
