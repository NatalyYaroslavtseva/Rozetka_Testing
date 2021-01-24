package cucumber;

import driver.DriverManager;
import io.cucumber.java.After;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CucumberHooks {

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
        log.info("=========================================");
        log.info("======== Test has been finished =========");
        log.info("=========================================");
    }
}