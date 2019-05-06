package com.workshop.gribletest.widgets;

import io.qameta.allure.Step;

public class Product {

    @Step
    public DataStorages openDataStorages() {
        new Section("Data Storages").click();
        return new DataStorages();
    }
}
