package com.workshop.gribletest.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Dialog {

    private SelenideElement container = $(".ui-dialog");


    @Step
    public Dialog setForLabel(String label, String value) {
        new DialogInput(this.container, label).setValue(value);
        return this;
    }

    @Step
    public void submit() {
        this.container.find("[id^=dialog-btn]").click();
    }
}
