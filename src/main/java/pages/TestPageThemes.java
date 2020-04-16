package pages;

import entities.TestPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestPageThemes extends TestPage {


    //ннотации добавить

    @FindBy(linkText = "Темы")
    public WebElement themePage;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-outline']")
    public WebElement themeCreate;

    @FindBy(xpath = "//input[@placeholder='Заголовок темы']")
    public WebElement themeCreateTitle;

    @FindBy(xpath = "//textarea[@id='editor-textarea']")
    public WebElement themeCreateDescription;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-right']")
    public WebElement themeCreateCancel;

    //всплывающее окно активируется и отменяется командой - browser.switchTo().alert().accept();


    //Кнопка Отправить ответ
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement themeCreateSubmit;

    //Поиск по названию темы. Подставляется значение переменной из Feature
    @FindBy(linkText = "<Заголовок темы>")
    public WebElement themeTitle;

    /*
    //Это похоже не в PageObject и это пока в разработке
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

    //Отписаться
    @FindBy(css = ".open > ul:nth-child(2) > li:nth-child(1) > button:nth-child(1) > span:nth-child(1)")
    public WebElement themeButtonUnsubscribe;
    //Подписаться
    @FindBy(css = ".open > ul:nth-child(2) > li:nth-child(2) > button:nth-child(1) > span:nth-child(1)")
    public WebElement themeButtonSubscribe;

    /**
     * Вкладки
     */
    @FindBy(linkText = "Все")
    public WebElement tabAll;

    @FindBy(xpath = "//a[@href='/my/']")
    public WebElement tabMy;

    @FindBy(xpath = "//a[@href='/new/']")
    public WebElement tabNew;

    @FindBy(xpath = "//a[@href='/unread/']")
    public WebElement tabUnread;

    @FindBy(xpath = "//a[@href='/subscribed/']")
    public WebElement tabSubscribed;


    /**
     * Ответить в теме
     */
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-outline']")
    public WebElement themeAnswerMessage;


}
