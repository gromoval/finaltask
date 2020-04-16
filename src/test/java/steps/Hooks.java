package steps;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import pages.TestPageAuthForm;
import webdriver.SharedDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

/**
 *
 */
public class Hooks {
    public final Logger log = LogManager.getLogger(getClass());

    /**
     *
     * @param scenario Scenario
     */
    @Before(value="@allGUITests")
    public void beforeGUIScenario(Scenario scenario) {
        log.info("Запуск GUI сценария {}", scenario.getName());
    }

    /**
     *
     * @param scenario
     */
    @Before(value="@allAPITests")
    public void beforeAPIScenario(Scenario scenario) {
        log.info("Запуск API сценария {}", scenario.getName());

        try {
            log.debug("Чтение и установка параметров запроса.");
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("test.properties"));
            RestAssured.requestSpecification = new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2/")
                    .addHeader("api_key", System.getProperty("api.key"))
                    .setAccept(ContentType.JSON)
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.ALL)
                    .build();
        } catch (IOException e) {
            log.error("Ошибка чтения параметров запроса: {}", e.getMessage());
        }
    }

    /**
     *
     * @param scenario
     */
    @After(value="@allGUITests")
    public void afterGUIScenario(Scenario scenario) {
        log.info("GUI Cценарий {} завершен", scenario.getName());
    }

    /**
     *
     * @param scenario
     */
    @After(value="@allAPITests")
    public void afterAPIScenario(Scenario scenario) {
        log.info("API Cценарий {} завершен", scenario.getName());
    }


}