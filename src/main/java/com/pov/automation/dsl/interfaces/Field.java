package com.pov.automation.dsl.interfaces;

import org.openqa.selenium.By;

public interface Field extends Element {
    void Write (String text, By locator);
    String Read (By locator);
}
