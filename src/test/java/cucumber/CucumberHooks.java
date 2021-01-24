package cucumber;

import driver.DriverManager;
import io.cucumber.java.After;

public class CucumberHooks {

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
