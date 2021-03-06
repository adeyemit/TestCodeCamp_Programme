package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    public WebDriver driver;

    @BeforeClass
        public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://web.facebook.com/?_rdc=1&_rdr");
        Thread.sleep(5000);
        driver.manage().window().fullscreen();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void loginTest() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("yemm002@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("10m@@@cc77");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        Thread.sleep(5000);
        if(driver.getCurrentUrl().contains("https://web.facebook.com/")){
            System.out.println(("PASSED - User Signed in Successfully"));
        }else {
            System.out.println("FAILED - User unable to SignIn");
        }
        Thread.sleep(10000);

    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
