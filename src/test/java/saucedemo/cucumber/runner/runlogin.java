package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features",
        glue = "saucedemo.cucumber.stepdef",
        plugin = {"html:target/html_report.html"}

)
public class runlogin {
}
