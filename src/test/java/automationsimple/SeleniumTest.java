package automationsimple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;
    @Test
    public void loginTest(){

        //open browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        //enter an email
        driver.findElement(By.id("login")).sendKeys("automationtest");
        //click login button
        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

        WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifmail")));


        WebElement iframe = driver.findElement(By.id("ifmail"));

        driver.switchTo().frame(iframe);

        String txtActualBerhasilLogin = driver.findElement(By.xpath("//strong[.='Thanks for connecting!']")).getText();
        String txtExpectedBerhasilLogin = "Welcome to Brick&Bolt! (Thanks for connecting!)";

        Assert.assertEquals(txtActualBerhasilLogin,txtExpectedBerhasilLogin);


//        driver.quit();
    }


}

