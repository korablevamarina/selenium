package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Lesson6 {
    private DiaryPage diaryPage;

    @BeforeEach
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        EventFiringWebDriver driver = new EventFiringWebDriver(chromeDriver);
        driver.register(new CustomEventListener());
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

        assertNotNull(result);
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

    @AfterEach
    public void tearDown() {
        // Вывод всех ошибок браузера после каждого теста
        LogEntries browserLogs = diaryPage.getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();

        if (allLogRows.size() > 0) {
            // Обработка ситуации
            allLogRows.forEach(
                    System.err::println
            );
        }
        // -------------------------------
        diaryPage.getDriver().quit();
    }
}
