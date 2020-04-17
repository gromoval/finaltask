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
    public WebElement authFormIncorrectCredentialsAlert;

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

    @NameOfElement("страница_темы")
    @FindBy(xpath = "//a[href='/']")
    public WebElement themePage;

    @NameOfElement("кнопка_создания_новой_темы")
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-outline']")
    public WebElement themeCreate;

    @NameOfElement("заголовок_темы")
    @FindBy(xpath = "//input[@placeholder='Заголовок темы']")
    public WebElement themeCreateTitle;

    @NameOfElement("сообщение_темы")
    @FindBy(xpath = "//textarea[@id='editor-textarea']")
    public WebElement themeCreateDescription;

    @NameOfElement("кнопка_отмены_публикации")
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-right']")
    public WebElement themeCreateCancel;

    @NameOfElement("кнопка_публикации_темы")
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement themeCreateSubmit;

    /**
     * Ответить в теме
     */
    @NameOfElement("ответить")
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-outline']")
    public WebElement themeAnswerMessage;

    @NameOfElement("тема_форума")
    @FindBy(tagName = "h1")
    public WebElement themeForum;

    //Поиск по названию темы. Подставляется значение переменной из Feature
//    @NameOfElement("название_темы")
//    @FindBy(linkText = "<Заголовок темы>")
//    public WebElement themeTitle;

    @NameOfElement("название_темы")
    @FindBy(xpath = "//div[@class='post-body']")
    public WebElement themeName;

    /*
    //Поиск кнопки Неактивна/Активна на строке с названием темы
    List<WebElement> element = driver.findElements(By.linkText("<Заголовок темы>"));
    Point classname = element.get(0).getLocation();
    int y = classname.getY() + 10; //разметка на сайте непостоянная, и кнопка в разных строках по разному съезжает
    // относительно местонахождения названия темы, поэтому +10. Но не везде опять же работает, боремся с этим)
    int constStar = 1185; //постоянная позиция Звездочки в кнопке по оси Y
    Actions builder = new Actions(driver);
    builder.moveByOffset(constStar, y).click().build().perform();
        */

//    @FindBy(xpath = "//div[@class='btn-group btn-group-justified']")
//    public WebElement themeButtonActiveOrNotActive;

    @NameOfElement("отписаться")
    @FindBy(css = ".open > ul:nth-child(2) > li:nth-child(1) > button:nth-child(1) > span:nth-child(1)")
    public WebElement themeButtonUnsubscribe;

    @NameOfElement("подписаться")
    @FindBy(css = ".open > ul:nth-child(2) > li:nth-child(2) > button:nth-child(1) > span:nth-child(1)")
    public WebElement themeButtonSubscribe;

    /**
     * Вкладки
     */
    @NameOfElement("все")
    @FindBy(linkText = "Все")
    public WebElement tabAll;

    @NameOfElement("мои")
    @FindBy(xpath = "//a[@href='/my/']")
    public WebElement tabMy;

    @NameOfElement("новые")
    @FindBy(xpath = "//a[@href='/new/']")
    public WebElement tabNew;

    @NameOfElement("непрочитанные")
    @FindBy(xpath = "//a[@href='/unread/']")
    public WebElement tabUnread;

    @NameOfElement("подписки")
    @FindBy(xpath = "//a[@href='/subscribed/']")
    public WebElement tabSubscribed;
}


