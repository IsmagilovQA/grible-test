package com.workshop.gribletest.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class ContextMenu {

    // Another way how to handle a bit different context menus (instead of creation of two constructors)

    /*
    public static ContextMenu commonContextMenu(SelenideElement element) {
        return new ContextMenu( $$(".context-menu-list").findBy(visible), element);
    }

    public static ContextMenu spesialContextMenu(SelenideElement element) {
        return new ContextMenu( $$(".special-context-menu-list").findBy(visible), element);
    }
    */

    private final SelenideElement container;
    private final SelenideElement element;


    public ContextMenu(SelenideElement container, SelenideElement element) {
        this.container = container;
        this.element = element;
    }

    public ContextMenu(SelenideElement element) {
        this($$(".context-menu-list").findBy(visible), element);
    }

    @Step
    public ContextMenu open() {
        this.element.contextClick();
        return this;
    }

    @Step
    public void select(String item) {
        this.container.find(byText(item)).click();
    }

    @Step
    public ContextMenu editInput(String label, String value) {
        inputFor(label).setValue(value);
        return this;
    }

    @Step
    public MenuInput inputFor(String label) {
        return new MenuInput(this.container, label);
    }
}
