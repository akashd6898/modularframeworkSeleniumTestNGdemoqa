package com.demoqa.tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ElementPageTests extends BaseTests {
    @Test
    public void openElementPage()
    {
        reportsUtils.createTestCase("Open Elements Page -1");
        reportsUtils.addTestLog(Status.INFO, "Opening Elements Page -2");
        elementsPage.OpenElementsPage();
        elementsPage.openTextBoxModule();
    }
    @Parameters({"fullName", "email", "currentAddress", "permanentAddress"})
    @Test
    public void fillElementPageTextModule(String fullName, String email, String currentAddress, String permanentAddress)
    {
        reportsUtils.createTestCase("Type Text Elements Page Module-3");
        reportsUtils.addTestLog(Status.INFO, "Typing text in  Elements Page -4");
        elementsPage.typeTextElementModule(fullName, email, currentAddress, permanentAddress);
    }

}
