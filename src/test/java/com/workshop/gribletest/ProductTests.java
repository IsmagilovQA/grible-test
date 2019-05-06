package com.workshop.gribletest;

import com.codeborne.selenide.Configuration;
import com.workshop.gribletest.testconfigs.BaseTest;
import com.workshop.gribletest.widgets.Home;
import org.junit.Test;

import static com.workshop.gribletest.widgets.Gherkin.*;


public class ProductTests extends BaseTest {

    {
        Configuration.holdBrowserOpen = false;
    }

    // Atomic tests which check one feature (function)

    @Test
    public void createsProduct() {
        GIVEN("At Home page: ensure 'Atomic product' does not exist");
        Home home = new Home();
        home.openProduct();
        home.ensureNoProduct("Atomic product");

        WHEN("New product created");
        home.addProduct("Atomic product", "Path " + System.currentTimeMillis());

        EXPECT("New product is shown in list");
        home.shouldHaveProduct("Atomic product");
    }


    @Test
    public void deletesProduct() {
        GIVEN("At Home page - ensure 'Atomic product' exist");
        Home home = new Home();
        home.openProduct();
        home.ensureProduct("Atomic product", "Path " + System.currentTimeMillis());

        WHEN("Product deleted");
        home.deleteProduct("Atomic product");

        EXPECT("Product is not shown in list");
        home.shouldNotHaveProduct("Atomic product");
    }
}
