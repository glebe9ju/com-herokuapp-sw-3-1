package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginWithValidCredential(){

        sendTexttoElement(By.name("username"),"tomsmith");
        sendTexttoElement(By.id("password"),"SuperSecretPassword");
        clickOnElement(By.className("radius"));

//        WebElement secureArea = driver.findElement(By.xpath("//div[@class='example']//h2"));
//        System.out.println(secureArea.getText());
        String secureArea = getTextFromElement(By.xpath("//div[@class='example']//h2"));
        //Verify the text “Secure Area”
        Assert.assertEquals("Incorrect Login detail" , "Secure Area",secureArea);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        // Enter “tomsmith1” username

        sendTexttoElement(By.name("username"),"tomsmith2");
        //Enter “SuperSecretPassword!” password
       sendTexttoElement(By.id("password"),"SuperSecretPassword!");
        // Click on ‘LOGIN’ button
         clickOnElement(By.className("radius"));
        String invalidUserName1 = getTextFromElement(By.id("flash"));
        //Verify the error message “Your username is invalid!”
        Assert.assertEquals("Incorrect login detail","Your username is invalid!\n×",invalidUserName1);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username

        sendTexttoElement(By.name("username"),"tomsmith");
        // Enter “SuperSecretPassword” password
        sendTexttoElement(By.id("password"),"SuperSecretPassword1!");
        //Click on ‘LOGIN’ button
        clickOnElement(By.className(("radius")));
        //Verify the error message “Your password is invalild!"
//        WebElement invalidPassWor = driver.findElement(By.id("flash"));
//        System.out.println(invalidPassWor.getText());
        String invalidPassWor = getTextFromElement(By.id("flash"));
        Assert.assertEquals("Incorrect password","Your password is invalid!\n×",invalidPassWor);

    }
    @After
    public void tearDown() {
        closeBrowsers();
    }

}
