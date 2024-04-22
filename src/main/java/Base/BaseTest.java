package Base;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    By txtfirstName = By.id("firstName");

    By txtlastName = By.id("lastName");

    By btnsignup = By.cssSelector("[id='signup']");

    @Test
    public void REGISTRATION() {
        driver = new ChromeDriver();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(btnsignup).click();
        driver.findElement(txtfirstName).sendKeys("Cansu");
        driver.findElement(txtlastName).sendKeys("Dirlik");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("cbuldak3@gmail.com");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234567");
        driver.findElement(By.cssSelector("[id='submit']")).click();

    }
}
