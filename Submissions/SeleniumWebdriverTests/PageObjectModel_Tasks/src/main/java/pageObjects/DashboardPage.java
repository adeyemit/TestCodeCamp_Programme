package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    //Create a webDriver object for this class
    private WebDriver driver;

    //Create a constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By welcomeAdmin = By.cssSelector("#branding a:nth-child(2)");
    private By logOut = By.linkText("Logout");

    public void clickWelcomeAdmin() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(welcomeAdmin).click();
    }
    public LoginPage clickLogout() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(logOut).click();
        return new LoginPage(driver);
    }
}
