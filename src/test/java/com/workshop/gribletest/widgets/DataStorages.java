package com.workshop.gribletest.widgets;

import io.qameta.allure.Step;

public class DataStorages {

    @Step
    public void addCategory(String name) {
        new Categories().add(name);
    }


    @Step
    public void addDataStorage(String category, String name) {
        new Category(category)
                .menu()
                .open()
                .select("Add storage");
        new Dialog()
                .setForLabel("Name:", name)
                .setForLabel("Class name:", name)
                .submit();
    }

    @Step
    public Table table() {
        return new Table();
    }
}
