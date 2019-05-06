package com.workshop.gribletest.testconfigs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.workshop.gribletest.widgets.App;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

    public App app = new App(); // object has access to all all widgets (it's one entry point) - see the example in test 'testExampleWithOneEntryPoint()'

    @BeforeClass
    public static void baseinit() {
        Configuration.baseUrl = "http://0.0.0.0:8123";
        Configuration.fastSetValue = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterClass
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
