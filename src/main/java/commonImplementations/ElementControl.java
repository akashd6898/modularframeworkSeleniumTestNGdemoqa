package commonImplementations;

import org.openqa.selenium.WebElement;

public class ElementControl {

    public void clickElement(WebElement element)
    {
        element.click();
    }
    public void typeElement(WebElement element, String text)
    {
        element.sendKeys(text);
    }
    public void clearElement(WebElement element)
    {
        element.clear();
    }
    public boolean isEnabled(WebElement element)
    {
        return element.isEnabled();
    }
    public boolean isDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }
}
