package org.example;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiaryPage {

    @Getter
    private final WebDriver driver;

    @FindBy(css = ".i-search:nth-child(1)")
    private WebElement search;

    @FindBy(css = "form:nth-child(3) #menusearchform-sq")
    private WebElement searchText;

    @FindBy(css = "form:nth-child(3) .btn-plain")
    private WebElement searchSubmit;

    @FindBy(css = ".gsc-result-info")
    private WebElement searchResult;

    @FindBy(linkText = "Вход")
    private WebElement exit;

    @FindBy(name = "LoginForm[username]")
    private WebElement loginField;

    @FindBy(id = "loginform-password")
    private WebElement passwordField;

    @FindBy(className = "recaptcha-checkbox-border")
    private WebElement captcha;

    @FindBy(id = "login_btn")
    private WebElement loginBtn;

    @FindBy(linkText = "Новая запись")
    private WebElement newPostBtn;

    @FindBy(id = "postTitle")
    private WebElement postTitle;

    @FindBy(css = "html")
    private WebElement newField;

    @FindBy(xpath = "//html")
    private WebElement postText;

    @FindBy(id = "rewrite")
    private WebElement rewriteBtn;

    public DiaryPage switchToFrame(int n) {
        driver.switchTo().frame(n);
        return this;
    }

    public DiaryPage switchToParentFrame() {
        driver.switchTo().parentFrame();
        return this;
    }

    public DiaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DiaryPage clickOnSearch() {
        search.click();
        return this;
    }

    public DiaryPage typeSearchText(String text) {
        searchText.sendKeys(text);
        return this;
    }

    public DiaryPage clickOnSearchSubmit() {
        searchSubmit.click();
        return this;
    }

    public String getResult() {
        return searchResult.getText();
    }

    public DiaryPage enter() {
        String address = "https://diary.ru";
        driver.get(address);
        return this;
    }

    public DiaryPage clickOnExit() {
        exit.click();
        return this;
    }

    public DiaryPage typeLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public DiaryPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public DiaryPage typePostTitle(String title) {
        postTitle.sendKeys(title);
        return this;
    }

    public DiaryPage typePostText(String text) {
        postText.sendKeys(text);
        return this;
    }

    public DiaryPage loginBtnClick() {
        loginBtn.click();
        return this;
    }

    public DiaryPage newPostBtnClick() {
        newPostBtn.click();
        return this;
    }

    public DiaryPage postTitleClick() {
        postTitle.click();
        return this;
    }

    public DiaryPage newFieldClick() {
        newField.click();
        return this;
    }

    public DiaryPage rewriteBtnClick() {
        rewriteBtn.click();
        return this;
    }

    public DiaryPage waitForCaptcha() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(captcha));
        return this;
    }

    public DiaryPage clickOnCaptcha() {
        captcha.click();
        return this;
    }

    public DiaryPage waitForLoginBtn() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(loginBtn));
        return this;
    }
}