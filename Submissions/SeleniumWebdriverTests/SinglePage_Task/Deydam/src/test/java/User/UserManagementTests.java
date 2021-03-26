package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    private WebDriver driver;

    @BeforeClass
        public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        Thread.sleep(5000);
        driver.manage().window().fullscreen();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
        public void loginTest() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("adeyemit");
        driver.findElement(By.id("password")).sendKeys("lovely10");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")){
            System.out.println("PASSED - User has successfully logged in");
        }else{ System.out.println("FAILED - The user was unable to login");
        }
        Thread.sleep(10000);
    }
    @Test
        public void logoutTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Log Out")).click();
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")){
            System.out.println("PASSED - User has successfully logged out");
        }else {
            System.out.println("FAILED - The user was still logged in");
        }
        Thread.sleep(5000);


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
