package commonImplementations.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {

    TakesScreenshot screenCapture;

    public ScreenshotUtils(WebDriver driver)
    {
        screenCapture = (TakesScreenshot) driver;
    }

    public void saveScreenshot(String fileName) throws Exception {
        fileName = fileName.trim();

        File tmpFile, imgFile;

        imgFile = new File(fileName);

        if(imgFile.exists())
        {
            throw new Exception("File already exists");
        }

        tmpFile = screenCapture.getScreenshotAs(OutputType.FILE);
        FileUtils.moveFile(tmpFile, imgFile);
    }
}
