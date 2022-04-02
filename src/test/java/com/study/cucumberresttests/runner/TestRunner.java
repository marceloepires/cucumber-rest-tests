package com.study.cucumberresttests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/com/study/cucumberresttests/features"},
        plugin = {"json:target/cucumber.json", "pretty"},
        glue = "com.study.cucumberresttests.steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
