package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    // This method will click on element
    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public void sendTexttoElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

}
