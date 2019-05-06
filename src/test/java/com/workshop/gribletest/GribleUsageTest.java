package com.workshop.gribletest;

import com.codeborne.selenide.Configuration;
import com.workshop.gribletest.testconfigs.BaseTest;
import com.workshop.gribletest.widgets.DataStorages;
import com.workshop.gribletest.widgets.Home;
import com.workshop.gribletest.widgets.Product;
import com.workshop.gribletest.widgets.Table;
import org.junit.Test;

import static com.workshop.gribletest.widgets.Gherkin.*;
import static java.util.Arrays.asList;


public class GribleUsageTest extends BaseTest {

    {
        Configuration.holdBrowserOpen = false;
    }

    // End to End test (integration) which checks main business flow

    @Test
    public void createTestTableBasedOnDataStorageForNewProduct() {
        GIVEN("At Home page");
        Home home = new Home();
        home.openProduct();
        String productName = "Product " + System.currentTimeMillis();
        String path = "Path " + System.currentTimeMillis();

        WHEN("New product created");
        home.addProduct(productName, path);

        AND("Its Data Storages opened");
        Product product =
                home.openProduct(productName); // transition to Product page

        DataStorages dataStorages =
                product.openDataStorages(); // transition to DataStorage page

        THEN("Create two Data Storages under new category created");
        dataStorages.addCategory("Users");
        dataStorages.addDataStorage("Users", "Blobs");
        dataStorages.addDataStorage("Users", "Credentials");

        EXPECT("Storage table with one column 'editme' and one empty row");
        Table storage =
                dataStorages.table(); // transition to Table

        storage.shouldHaveColumnHeaders("editme");
        storage.shouldHaveRows(asList(""));

        THEN("Edit current column name and add one more column");
        storage.column(0).setName("user");
        storage.addColumnAfter(0, "password");
    }


//    @Test
//    public void testExampleWithOneEntryPoint() {
//        app.products().openProduct();
//        String name = "Product " + System.currentTimeMillis();
//        app.products().addProduct(name);
//        app.products().openProduct(name);
//    }
}

