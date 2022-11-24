import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPageTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(MainMenuPageTest.class);

    @Test
    void openLoginWidgetTest() throws InterruptedException {
        logger.info("Тест на открытие виджета логина начат");

        LoginPage loginWidget = new LoginPage(getWebDriver());
        loginWidget.clickSignInButton();
        Thread.sleep(5000);
        String itemName = getWebDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText();
        Assertions.assertTrue(itemName.contains(getWebDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText()));
        logger.info("Тест на открытие виджета логина завершен");
    }

    @Test
    void userLoginTest() throws InterruptedException {
        logger.info("Тест по авторизации начат");

        LoginPage userLogin = new LoginPage(getWebDriver());
        userLogin.userLoginPassword("MariyaMarusya", "567Rjvgjn");
        Thread.sleep(5000);

        String itemName = getWebDriver().findElement(By.xpath("//a[contains(@href, 'https://mariyamarusya.livejournal.com/')]")).getText();
        Assertions.assertEquals(true, itemName.contains(getWebDriver().findElement(By.xpath("//a[contains(@href, 'https://mariyamarusya.livejournal.com/')]")).getText()));
        logger.info("Тест по авторизации завершен");
    }
}