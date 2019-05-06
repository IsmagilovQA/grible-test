package com.workshop.gribletest.widgets;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Categories {

    @Step
    public Categories add (String name) {
        $("#btn-add-category").click();
        new Dialog()
                .setForLabel("Name:", name)
                .submit();
        return this;
    }
}
