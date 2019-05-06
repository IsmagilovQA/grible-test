package com.workshop.gribletest.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;

public class MenuInput {

    private final SelenideElement parent;
    private final String label;

    public MenuInput(SelenideElement container, String label) {
        this.parent = container;
        this.label = label;
    }

    @Step
    public SelenideElement element() {
        return this.parent.find(withText(this.label)).find(byXpath("../input"));
    }

    @Step
    public MenuInput setValue(String name) {
        element().click();
        element().val(name);
        return this;
    }
}
