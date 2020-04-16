package pages;

import entities.NameOfElement;
import entities.TestPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPageThemes extends TestPage {

    @NameOfElement("темы")
    @FindBy(linkText = "Темы")
    public WebElement themePage;

    @NameOfElement("создать_тему")
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-outline']")
    public WebElement themeCreate;

    @NameOfElement("заголовок_темы")
    @FindBy(xpath = "//input[@placeholder='Заголовок темы']")
    public WebElement themeCreateTitle;

    @NameOfElement("описание_темы")
    @FindBy(xpath = "//textarea[@id='editor-textarea']")
    public WebElement themeCreateDescription;

    @NameOfElement("отмена_создания_темы")
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-right']")
    public WebElement themeCreateCancel;

    @NameOfElement("кнопка_отправить_ответ")
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement themeCreateSubmit;

    /**
     * Ответить в теме
     */
    @NameOfElement("ответить")
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-outline']")
    public WebElement themeAnswerMessage;

    //Поиск по названию темы. Подставляется значение переменной из Feature
    @NameOfElement("название_темы")
    @FindBy(linkText = "<Заголовок темы>")
    public WebElement themeTitle;

    /*
    //Это похоже не в PageObject и это пока в разработке (может легче переписать шаг сценария)
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