package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KongaTests {
    //import Selenium WebDriver
    private WebDriver driver;

    //functions before test commence

    @BeforeClass
        public void setUp() throws InterruptedException {
        //fetch the chromeDriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get("https://www.konga.com/");
        // wait for 5 Secs for Page to Load
        Thread.sleep(5000);
        //maximize the browser
        driver.manage().window().maximize();
        //Get Page Title
        System.out.println(driver.getCurrentUrl());
        //Make page wait for 10 Secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
        public void loginTest() throws InterruptedException {
        //click on Login / Signup Button
        driver.findElement(By.linkText("Login / Signup")).click();
        //input a valid email in the Email/Phone No Field
        driver.findElement(By.id("username")).sendKeys("elmacdlb@gmail.com");
        //input a valid password in the password Field
        driver.findElement(By.id("password")).sendKeys("yemikonga");
        //Click on Login Button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://www.konga.com/")){
            System.out.println("PASSED - User Logged-in");
        }else{
            System.out.println("FAILED - User cannot Log-in");
        }
        //to wait a bit
        Thread.sleep(15000);

        //Click on "Computers and Accessories"
        driver.findElement(By.linkText("Computers and Accessories")).click();
        Thread.sleep(5000);

        //Click on SubCategory "Laptops"
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(5000);

        //Click on Apple MacBooks
        driver.findElement(By.linkText("Apple MacBooks")).click();
        Thread.sleep(5000);

        //Click on the Add to Cart Button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[4]/button")).click();
        Thread.sleep(5000);

        //click on My Cart Button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[2]/div/div/a[2]")).click();
        Thread.sleep(5000);

        //In Cart Overview - Click On Checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);

        //Click on Change Address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div/div/section[1]/div[2]/div/div[1]/div/div[1]/form/div/div/a")).click();
        Thread.sleep(5000);

        //Click On Use this Address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

        //Click On Pay Now
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG _4a291_2cOtr' and @name = 'selectPaymentMethod']")).click();
        Thread.sleep(5000);

        //Click on the Continue to Payment button
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG' and @name='placeOrder']")).click();

        //switch to the iframe element
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(iframe);
        //Click to select card payment type By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[9]/div/button").findElement(driver).click();
        driver.findElement(By.xpath("(//span[@class='payment-option-info'])[2]")).click();
        Thread.sleep(15000);
        /*
         Select card payment
         driver.findElement(By.xpath("(//span[@class='payment-option-info'])[2]")).click();
         Thread.sleep(10000);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         */
        //Enter card details
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //input invalid card details
        driver.findElement(By.id("card-number")).sendKeys("5222608071239800");

        //input expiry date
        driver.findElement(By.id("expiry")).sendKeys("05/24");

        //input CVV
        driver.findElement(By.id("cvv")).sendKeys("753");
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(8000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //print out Error message
        System.out.println(driver.findElement(By.xpath("//label[@id='card-number_unhappy']")).getText());

        //Click on close modal frame
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);

    }

    @AfterTest
        public void teardown(){
            driver.quit();
    }



}
