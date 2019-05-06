package com.workshop.gribletest.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Home {

    @Step
    public void openProduct() {
        Selenide.open("/");
    }


    @Step
    public void addProduct(String name, String path) {
        $("#btn-add-product").click();
        new Dialog()
                .setForLabel("Name:", name)
                .setForLabel("Path:", path)
                .submit();
        new ConfirmationDialog().confirm();
    }

    @Step
    public void addProduct(String name) {
        addProduct(name, name);
    }


    @Step
    public Product openProduct(String name) {
        new Section(name).click();
        return new Product();
    }


    @Step
    public void ensureProduct(String productName, String path) {
        if (!satisfied(getProductElement(productName), visible)) {
            addProduct(productName, path);
        }
    }


    @Step
    public void ensureNoProduct(String productName) {
        if (satisfied(getProductElement(productName), visible)) {
            deleteProduct(productName);
        }
    }


    @Step
    public void shouldHaveProduct(String productName) {
        getProductElement(productName).shouldBe(visible);
    }

    @Step
    public void shouldNotHaveProduct(String productName) {
        getProductElement(productName).shouldNotBe(visible);
    }

    @Step
    private SelenideElement getProductElement(String productName) {
        return new Section(productName).element().find(".product-item");
    }

    @Step
    public void deleteProduct(String productName) {
        new ContextMenu(getProductElement(productName))
                .open()
                .select("Delete product");
        new ConfirmationDialog()
                .confirm();
    }

    // method helper
    private static boolean satisfied(SelenideElement element, Condition condition) {
        try {
            element.should(condition);
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }
}
