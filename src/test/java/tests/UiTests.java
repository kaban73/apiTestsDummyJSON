package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UiTests {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(groups = "smoke")
    public void sauceDemoPageOpenedTest() {
        boolean logoDisplayed =
                driver.findElement(By.className("login_logo")).isDisplayed();

        assertTrue(logoDisplayed);
    }

    @Test(groups = "smoke")
    public void validLoginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        assertEquals(
                driver.findElement(By.className("title")).getText(),
                "Wrong title"
        );
    }
    String abc = 123;
    @Test(groups = "regression")
    public void invalidLoginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("wrong_password");

        driver.findElement(By.id("login-button"))
                .click();

        assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']"))
                        .isDisplayed()
        );
    }
}

