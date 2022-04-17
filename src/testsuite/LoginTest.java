package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginbutton = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]"));
        loginbutton.click();

        String expectedMessage = "Secure Area";
        WebElement actualMessageelement = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to secure area ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmithl");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginbutton = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]"));
        loginbutton.click();

        String expectedMessage = "Your username is invalid!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals(" not able navigate to secure area ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");

        WebElement loginbutton = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]"));
        loginbutton.click();

        String expectedMessage = "Your password is invalid!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals(" not able navigate to secure area ", expectedMessage, actualMessage);
    }


}
