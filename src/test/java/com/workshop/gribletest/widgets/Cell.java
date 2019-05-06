package com.workshop.gribletest.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Cell {

    private final SelenideElement container;


    public Cell(SelenideElement container) {
        this.container = container;
    }

    @Step
    public ContextMenu menu() {
        return new ContextMenu($(".htContextMenu"), this.container);
    }
}
