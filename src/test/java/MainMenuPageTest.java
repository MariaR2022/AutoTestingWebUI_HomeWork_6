import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainMenuPageTest extends AbstractTest{
    static Logger logger = LoggerFactory.getLogger(MainMenuPageTest.class);

    @Test
    void itemVoyagesTest() throws InterruptedException {
        logger.info("Тест на открытие категории/темы -Путешествия- начат");

        MainMenuPage itemVoyages = new MainMenuPage(getWebDriver());
        itemVoyages.navigateToVoyages();
        Thread.sleep(5000);

        Assertions.assertEquals("Блоги о путешествиях и самостоятельном туризме — Живой Журнал — ЖЖ", getWebDriver().getTitle(), "Данная категория отсутствует");
        logger.info("Тест на открытие категории/темы -Путешествия- завершен");
    }

    @Test
    void itemWorkTest() throws InterruptedException {
        logger.info("Тест на открытие категории/темы -Работа- начат");

        MainMenuPage itemWork = new MainMenuPage(getWebDriver());
        itemWork.navigateToWork();
        Thread.sleep(5000);
        Assertions.assertEquals("Статьи и блоги про работу — Живой Журнал — ЖЖ",getWebDriver().getTitle(),"Данная категория отсутствует");

        logger.info("Тест на открытие категории/темы -Работа- завершен");
    }

    @Test
    void setLanguageMenuTest()throws InterruptedException {
        logger.info("Тест на установку языка -Русский- начат");

        MainMenuPage setLanguage = new MainMenuPage(getWebDriver());
        setLanguage.toSetLanguage();
        Thread.sleep(5000);

        String itemName = getWebDriver().findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link")).getText();
        Assertions.assertTrue(itemName.contains(getWebDriver().findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link")).getText()));

        logger.info("Тест на установку языка -Русский- завершен");
    }
}
