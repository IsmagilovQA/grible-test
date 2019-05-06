package com.workshop.gribletest.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;

public class DialogInput {

    private final SelenideElement parent;
    private final String label;

    public DialogInput(SelenideElement parent, String label) {
        this.parent = parent;
        this.label = label;
    }

    @Step
    private SelenideElement element() {
        //container.$(withText(label)).find(byXpath("./following-sibling::*/input"));
        //container.$(withText(label)).find(byXpath("..")).find("input");
        return this.parent.find(withText(label)).parent().find("input");

    }

    @Step
    public void setValue(String value) {
        element().val(value);
    }
}
