package com.pov.automation.dsl.interfaces;

import org.openqa.selenium.By;

public interface Element {
    void Exists(int timeout, By locator);
}
