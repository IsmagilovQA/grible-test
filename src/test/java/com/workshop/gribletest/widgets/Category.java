package com.workshop.gribletest.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class Category {

    private final String name;


    public Category(String name) {
        this.name = name;
    }

    @Step
    public ContextMenu menu() {
        return new ContextMenu(element());
    }

    @Step
    public SelenideElement element() {
        return $$(".category-item").findBy(exactText(this.name));
    }

}
