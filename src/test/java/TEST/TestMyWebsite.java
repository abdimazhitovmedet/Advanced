package TEST;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestMyWebsite {
    static WebDriver driver;
    @Before
    public void beforeMethod(){
        System.out.println("1");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      //driver.get("Users/aidaomuralieva/Desktop/Techtorial.html");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("file:///Users/aidaomuralieva/Desktop/Techtorial.html");


    }
    @Test
    public void test1() throws InterruptedException{
        System.out.println("2");
    Thread.sleep(3000);
        String welcomeText = driver.findElement(By.id("WelcomeText")).getText();
        System.out.println(welcomeText);
        String expectedText = "Welcome to my Website";
        Assert.assertEquals(expectedText,welcomeText);
        Assert.assertFalse(!welcomeText.equals(expectedText));
        Assert.assertTrue(welcomeText.equals(expectedText));
    }
    @Test
    public void test2() throws InterruptedException{
        System.out.println("4");
        Thread.sleep(3000);
        List<WebElement> listName =driver.findElements(By.id("name"));
        for (WebElement s: listName){
            System.out.println(s.getText());
        }
        List<WebElement>table = driver.findElements(By.xpath("//*/tr"));
        table.remove(0);
        for (WebElement d: table){
            System.out.println(d.getText());
        }



    }

    @After
    public void afterMethod(){

        System.out.println("3");
        driver.quit();


    }











}
