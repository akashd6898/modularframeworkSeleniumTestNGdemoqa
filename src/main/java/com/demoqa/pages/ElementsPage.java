package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage{

    @CacheLookup
    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement elementsCard;

    @CacheLookup
    @FindBy(id = "item-0")
    private WebElement textBoxModule;

    @CacheLookup
    @FindBy(id = "userName")
    private WebElement fullNameElement;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement emailElement;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressElement;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressElement;

    public ElementsPage(WebDriver driver)
    {
        super();
        PageFactory.initElements(driver, this);
    }

    public void OpenElementsPage()
    {
        elementControl.clickElement(elementsCard);
    }

    public void openTextBoxModule()
    {
        elementControl.clickElement(textBoxModule);
    }

    public void typeTextElementModule(String fullName,String email, String currentAddress, String permanentAddress)
    {
        elementControl.typeElement(fullNameElement, fullName);
        elementControl.typeElement(emailElement, email);
        elementControl.typeElement(currentAddressElement, currentAddress);
        elementControl.typeElement(permanentAddressElement, permanentAddress);
    }

}
