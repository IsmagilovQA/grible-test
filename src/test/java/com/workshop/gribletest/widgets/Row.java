package com.workshop.gribletest.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class Row {

    private final SelenideElement container;


    public Row(SelenideElement container) {
        this.container = container;
    }

    @Step
    public Cell cell(int index) {
        return new Cell(cellsElements().get(index));
    }

    @Step
    public ElementsCollection cellsElements() {
        return this.container.findAll("td");
    }
}
