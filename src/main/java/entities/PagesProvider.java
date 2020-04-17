package entities;

import org.openqa.selenium.WebElement;
import pages.TestPageAuthForm;

public class PagesProvider {
    private TestPageAuthForm pageAuthForm = new TestPageAuthForm();

    public WebElement getElementOnPage(String nameOfPage, String nameOfElement) {
        WebElement webElement = null;
        webElement = pageAuthForm.get(nameOfElement);
        return webElement;
    }
}
