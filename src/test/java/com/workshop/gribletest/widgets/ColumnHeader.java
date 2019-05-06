package com.workshop.gribletest.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ColumnHeader {

    private final SelenideElement container;


    public ColumnHeader(SelenideElement container) {
        this.container = container;
    }

    @Step
    public void setName(String name) {
        new ContextMenu(this.container)
                .open()
                .editInput("Column name", name)
                .select("Save");
    }
}
