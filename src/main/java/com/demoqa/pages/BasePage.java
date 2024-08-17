package com.demoqa.pages;

import commonImplementations.ElementControl;
import org.openqa.selenium.WebDriver;

public class BasePage {

    //WebDriver driver;

    public ElementControl elementControl;

    protected BasePage(/*WebDriver driver*/)
    {
        //this.driver = driver;
        elementControl = new ElementControl();
    }
}
