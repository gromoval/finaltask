package pages;

import entities.TestPage;
import entities.NameOfElement;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPageAuthForm extends TestPage {
    private final Logger log = LogManager.getLogger(getClass());


    @NameOfElement("главная_страница")
    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement homePage;

    @NameOfElement("кнопка_вызова_формы_авторизации")
    @FindBy(xpath = "//button[text()='Войти']")
    public WebElement authFormOpenButton;

    @FindBy(xpath = "//h4[text()='Войти']")
    public WebElement authFormTitle;

    @NameOfElement("логин")
    @FindBy(xpath = "//input[@id='id_username']")
    public WebElement authFormUsernameField;

    @NameOfElement("пароль")
    @FindBy(xpath = "//input[@id='id_password']")
    public WebElement authFormPasswordField;

    @NameOfElement("кнопка_ввода_данных_пользователя")
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement authFormSubmitButton;

    @FindBy(xpath = "//a[contains(.,'Забыли пароль')]")
    public WebElement authFormForgottenPswdLink;

    @NameOfElement("Поле_ввода_логина")
    @FindBy(xpath = "//p[text()='Логин или пароль неправильны.']")
    public WebElement authFormIncorrectCredentialsAlert ;

    @FindBy(xpath = "//p[text()='Заполните оба поля.']")
    public WebElement authFormEmptyCredentialsAlert;

    @FindBy(xpath = "//li[@class='dropdown']/a[@role='button']")
    public WebElement userAccountFormOpenLink;

    @NameOfElement("пиктограмма_активного_пользователя")
    @FindBy(xpath = "//img[@class=\"user-avatar\"]")
    public WebElement userAvatar;

    @NameOfElement("заголовок_личного_кабинета")
    @FindBy(xpath = "//li[@class='dropdown-header']/strong")
    public WebElement userAccountFormTitle;

    @NameOfElement("выход")
    @FindBy(xpath = "//button[text()='Выход']")
    public WebElement userAccountExitButton;
}
