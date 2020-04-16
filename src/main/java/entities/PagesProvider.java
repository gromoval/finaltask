package entities;

import org.openqa.selenium.WebElement;
import pages.TestPageAuthForm;
import pages.TestPageThemes;

public class PagesProvider {
    private TestPageAuthForm pageAuthForm = new TestPageAuthForm();
    private TestPageThemes testPageThemes = new TestPageThemes();

    public WebElement getElementOnPage(String nameOfPage, String nameOfElement) {
        WebElement webElement = null;
        switch (nameOfPage) {
            case "страница_авторизации":
            case "главная_страница":
                webElement = pageAuthForm.get(nameOfElement);
                break;
            case "Страница_Темы":
                webElement = testPageThemes.get(nameOfElement);
                break;
            case "Страница_Темы":
                webElement = testPageThemes.get(nameOfElement);
                break;
            default:
                webElement = null;
        }
        return webElement;
    }
}