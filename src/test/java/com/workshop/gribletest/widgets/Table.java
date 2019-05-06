package com.workshop.gribletest.widgets;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.util.Arrays.asList;

public class Table {

    private SelenideElement container = $("#table-container .htCore");


    @Step
    public ColumnHeader column(int index) {
        return new ColumnHeader(columnheadersElements().get(index));
    }

    @Step
    public SelenideElement head() {
        return this.container.find("thead");
    }

    @Step
    public ElementsCollection columnheadersElements() {
        return head().findAll(".colHeader");
    }

    @Step
    public SelenideElement body() {
        return this.container.find("tbody");
    }

    @Step
    public void addColumnAfter(int index, String name) {
        row(0)
                .cell(index)
                .menu()
                .open()
                .select("Insert column on the right");

        column(index + 1).setName(name);
    }

    @Step
    private Row row(int index) {
        return new Row(this.rowsElements().get(index));
    }

    @Step
    public ElementsCollection rowsElements() {
        return body().findAll("tr");
    }

    @Step
    public void shouldHaveColumnHeaders(String... texts) {
        List<String> headerTexts = new ArrayList<>();
        headerTexts.add("");
        headerTexts.addAll(asList(texts));
        headers().shouldHave(exactTexts(headerTexts.toArray(new String[0])));
    }

    @Step
    private ElementsCollection headers() {
        return head().findAll("th");
    }

    @Step
    public void shouldHaveRows(List<String>... textRows) {
        rowElements().shouldHave(size(textRows.length));
        for(int i = 0; i < textRows.length; i++) {
            columnElements(i).shouldHave(exactTexts(textRows[i].toArray(new String[textRows[i].size()])));
        }
    }

    @Step
    private ElementsCollection columnElements(int index) {
        return rowElements().get(index).findAll("td");
    }

    @Step
    private ElementsCollection rowElements() {
        return body().findAll("tr");
    }
}
