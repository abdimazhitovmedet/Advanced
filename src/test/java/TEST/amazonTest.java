package TEST;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class amazonTest {
    static WebDriver driver;
    @Before
    public void beforeM(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test1(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("camera"+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("p_89/Kodak")));
        driver.findElement(By.xpath("//li[@id='p_89/Kodak']")).click();
      String search=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))).getText();
   // String search = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(search);

    }
    @After
    public void afterM(){
        driver.quit();
    }


}
