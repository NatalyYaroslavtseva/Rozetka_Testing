package Cucumber;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @Before
    public void setupDriver() {
        DriverManager.getDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
