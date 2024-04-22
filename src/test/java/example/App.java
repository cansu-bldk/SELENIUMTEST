package example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    WebDriver driver;

    By txtfirstName = By.id("firstName");

    By txtlastName = By.id("lastName");

    By btnsignup = By.cssSelector("[id='signup']");

    String errorMessage1 = "Incorrect username or password";

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

    @Test
    public void LOGIN() {
         driver = new ChromeDriver();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("cbuldak3@gmail.com");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234567");
        driver.findElement(By.cssSelector("[id='submit']")).click();
    }

    @Test
    public void FAILPASSWORD() {
         driver = new ChromeDriver();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("cbuldak3@gmail.com");
        driver.findElement(By.cssSelector("[id='submit']")).click();
        String text = driver.findElement(By.cssSelector("[id='error']")).getText();

        Assert.assertEquals("errorMessage1", text);
    }

    @Test
    public void NONEDATA() {
         driver = new ChromeDriver();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("");
        driver.findElement(By.cssSelector("[id='submit']")).click();

    }

    @Test
    public void MINIMUMCHAR() {
        driver = new ChromeDriver();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(btnsignup).click();
        driver.findElement(txtfirstName).sendKeys("C");
        driver.findElement(txtlastName).sendKeys("D");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("test4@outlook.com");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("4785694665");
        driver.findElement(By.cssSelector("[id='submit']")).click();
    }

    @Test
    public void MAXIMUMCHAR() {
         driver = new ChromeDriver();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(btnsignup).click();
        driver.findElement(txtfirstName).sendKeys("ajhdajhsuahkuhakshahsahskahskahskahskuahsfkuahsfaufshk");
        driver.findElement(txtlastName).sendKeys("1234567654846541354684646543548487465435468768435435468");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("cbuldak3@gmail.com");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234567");
        driver.findElement(By.cssSelector("[id='submit']")).click();
    }

    @Test
    public void SUCCESSFULDATA() {
         driver = new ChromeDriver();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("cbuldak3@gmail.com");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234567");
        driver.findElement(By.cssSelector("[id='submit']")).click();

        String text = driver.findElement(By.xpath("/html/body/div/p[1]")).getText();

        Assert.assertEquals("Click on any contact to view the Contact Details", text);
    }


    @After
    public void afterTest() {driver.quit();}

}

