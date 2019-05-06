package com.workshop.gribletest.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class Section {

    private final String name;

    public Section(String name) {
        this.name = name;
    }


    @Step
    public SelenideElement element() {
        return $$(".section-cell").findBy(exactText(this.name));
    }


    @Step
    public void click() {
        element().click();
    }
}
