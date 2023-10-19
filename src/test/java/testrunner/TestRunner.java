package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "Features" }, glue = { "StepDefs" }, monochrome = true, plugin = { "pretty",
		"html:target/cucumber-html-report.html", "json:target/cucumber-json-report.json" })
public class TestRunner {

}
