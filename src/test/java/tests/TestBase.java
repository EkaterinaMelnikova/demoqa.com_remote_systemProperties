package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeFormPage;

import java.util.Map;



public class TestBase {

    TestData testData = new TestData();
    PracticeFormPage practiceFormPage= new PracticeFormPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.baseUrl = System.getProperty("baseUrl","https://demoqa.com");
        //Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.remote = System.getProperty("remoteUrl","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.timeout = 10000;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        System.out.println("Browser: " + Configuration.browser);
        System.out.println("BrowserSize: " + Configuration.browserSize);
        System.out.println("Remote: " + Configuration.remote);
    }



    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @AfterEach
    void addAttachments() {
        com.kimo.helpers.Attach.screenshotAs("Last screenshot");
        com.kimo.helpers.Attach.pageSource();
        com.kimo.helpers.Attach.browserConsoleLogs();
    }

}
