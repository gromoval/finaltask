package steps;

import entities.PagesProvider;
import org.openqa.selenium.*;
import pages.TestPageAuthForm;
import io.qameta.allure.Allure;
import io.cucumber.java.ru.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;

import webdriver.DriverFactory;
import webdriver.SharedDriver;

import java.io.IOException;


public class GUITestSteps {
    private final Logger log = LogManager.getLogger(getClass());
    private TestPageAuthForm page = new TestPageAuthForm();
    PagesProvider pagesProvider = new PagesProvider();

    /**
     * @param driver
     */
    public GUITestSteps(SharedDriver driver) {
    }

    /**
     * @param title String
     */
    public void addScreenshot(String title) {
        try {
            Allure.addAttachment(title, "image/png", FileUtils.openInputStream(page.getScreenshot()), ".png");
            log.debug("Сделан скриншот на шаге {}", title);
        } catch (IOException e) {
            log.error("Ошибка записи скриншота: {}", e.getMessage());
        }
    }

    @Пусть("я открыл браузер и загрузил страницу {string}")
    public void openBrowserAndLoadSite(String nameOfElement) {
        try {
            page.openPage(nameOfElement);
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

    @И("на {string} я нажал на элемент {string}")
    public void clickElement(String nameOfPage, String nameOfElement) {
        try {
            pagesProvider.getElementOnPage(nameOfPage, nameOfElement).click();
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

    @Когда("отобразился элемент {string}")
    public void loginFormDisplayed(String nameOfElement) {
        try {
            page.authFormUsernameField.isDisplayed();
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

    @Тогда("на {string} я ввел значение {string} в поле {string}")
    public void enterValue(String nameOfPage, String data, String nameOfElement) {
        try {
            pagesProvider.getElementOnPage(nameOfPage, nameOfElement).click();
            page.get(nameOfElement).sendKeys(data);
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

    @Тогда("на {string} отобразился элемент {string}")
    public void elementFound(String nameOfPage, String nameOfElement) {
        try {
            pagesProvider.getElementOnPage(nameOfPage, nameOfElement);
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

    @И("на {string} элемент {string} отображается {string}")
    public void elementFoundWithLogin(String nameOfPage, String nameOfElement, String login) {
        try {
            String avatarName = page.get(nameOfElement).getText();
            Assert.assertEquals(avatarName, login);
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

    @Тогда("я нажал на элемент {string}")
    public void clickElementExit(String nameOfElement) {
        try {
            page.get(nameOfElement).click();
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        }
//        finally {
//            addScreenshot(nameOfElement);
//        }
    }

    @И("появилось информационное окно")
    public void elementFoundInformationWindow() {
        try {
            //DriverFactory.getDriver().switchTo().alert().getText();
            Assert.assertEquals(DriverFactory.getDriver().switchTo().alert().getText(), "Вы уверены что хотите выйти?");
        } catch (TimeoutException e) {
            Assert.fail("Информационное окно не отобразилось! " + e.getMessage());
        }
//        finally {
//            //addScreenshot("информационное окно");
//        }
    }

    @Тогда("я нажал кнопку {string}")
    public void clickElementOk(String nameOfElement) {
        try {
            page.browserAlertAccept();
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

    @И("элемент {string} не отображается")
    public void elementNotFound(String nameOfElement) {
        try {
            page.get(nameOfElement).isEnabled();
        } catch (TimeoutException e) {
            Assert.fail(nameOfElement + " не доступна! " + e.getMessage());
        } finally {
            addScreenshot(nameOfElement);
        }
    }

}