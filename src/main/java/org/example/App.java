package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        testCase4(driver);
    }

    static void testCase1(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Проекты')]")));
        actions.click(driver.findElement(By.xpath("//span[contains(.,'Мои проекты')]")));
        actions.click(driver.findElement(By.linkText("Создать проект]")));
        actions.sendKeys(driver.findElement(By.name("crm_project[name]")),"241283111");
        actions.build().perform();

        Select sel = new Select(driver.findElement(By.tagName("crm_project[businessUnit]")));
        sel.selectByValue("Research & Development");
        sel = new Select(driver.findElement(By.tagName("crm_project[curator]")));
        sel.selectByValue("Амелин Владимир");
        sel = new Select(driver.findElement(By.tagName("crm_project[rp]")));
        sel.selectByValue("Воденеев Денис");
        sel = new Select(driver.findElement(By.tagName("crm_project[administrator]")));
        sel.selectByValue("Исаева Анастасия");
        sel = new Select(driver.findElement(By.tagName("crm_project[manager]")));
        sel.selectByValue("Горячев Алексей");
        actions.moveToElement(driver.findElement(By.cssSelector(".select2-default > .select2-arrow")));
        actions.moveToElement(driver.findElement(By.cssSelector(".select2-default > .select2-arrow")));
        actions.moveToElement(driver.findElement(By.id("select2-drop-mask")));
        actions.click(driver.findElement(By.cssSelector(".lang-ru")));
        actions.sendKeys(driver.findElement(By.cssSelector(".select2-focused")),"1234");
        actions.sendKeys(driver.findElement(By.cssSelector(".select2-focused")),"${KEY_ENTER}");
        actions.click(driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")));
    }

    static void testCase2(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

       Actions actions = new Actions(driver);
       actions.moveToElement(driver.findElement(By.xpath("first > .unclickable > .title")));
   }

    static void testCase3(WebDriver driver) {
        driver.get("https://diary.ru");
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.name("LoginForm[username]")).sendKeys("korablevamarina");
        driver.findElement(By.id("loginform-password")).sendKeys("korablevamarina");
        driver.switchTo().frame(2);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".recaptcha-checkbox-border")));
        driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
        driver.switchTo().parentFrame();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("login_btn")));
        driver.findElement(By.id("login_btn")).click();
        driver.findElement(By.linkText("Новая запись")).click();
        driver.findElement(By.id("postTitle")).click();
        driver.findElement(By.id("postTitle")).sendKeys("test3");
        driver.findElement(By.cssSelector("html")).click();
        driver.findElement(By.id("tinymce")).sendKeys("test3");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();
    }

    static void testCase4(WebDriver driver) {
        driver.get("https://diary.ru");
        driver.findElement(By.cssSelector(".i-search:nth-child(1)")).click();
        driver.findElement(By.cssSelector("form:nth-child(3) #menusearchform-sq")).sendKeys("музыка");
        driver.findElement(By.cssSelector("form:nth-child(3) .btn-plain")).click();
    }
}
