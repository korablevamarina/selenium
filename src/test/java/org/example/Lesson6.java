package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson6 {
    private DiaryPage diaryPage;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        diaryPage = new DiaryPage(driver);
    }

    @Test
    public void testSearchDiaryPage() {
        String result = diaryPage
                .enter()
                .clickOnSearch()
                .typeSearchText("музыка")
                .clickOnSearchSubmit()
                .getResult();

        Assert.assertNotNull(result);
    }

    @Test
    public void testLoginAndNewPostDiaryPage() {
        diaryPage
                .enter()
                .clickOnExit()
                .typeLogin("korablevamarina")
                .typePassword("korablevamarina")
                .switchToFrame(2)
                .waitForCaptcha()
                .clickOnCaptcha()
                .switchToParentFrame()
                .waitForLoginBtn()
                .loginBtnClick()
                .newPostBtnClick()
                .typePostTitle("test3")
                .typePostText("test3")
                .switchToParentFrame()
                .rewriteBtnClick();
    }
}
