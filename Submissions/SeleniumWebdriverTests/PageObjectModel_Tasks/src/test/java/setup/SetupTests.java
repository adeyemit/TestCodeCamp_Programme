package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class SetupTests {
    private WebDriver driver;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    @BeforeTest
        public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage  = new LoginPage(driver);

    }

    @AfterTest
        public void closeBrowser(){
        driver.quit();
    }

}
