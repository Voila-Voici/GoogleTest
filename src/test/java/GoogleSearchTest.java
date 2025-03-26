import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.ImagesGooglePage;
import web.MainGooglePage;
import web.PaginationPage;
import web.ResultGooglePage;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Web")
@DisplayName("Автоматизация сайта Google")
class GoogleSearchTest extends BaseTest {

    Logger logger = Logger.getLogger(GoogleSearchTest.class.getName());
    private final MainGooglePage mainGooglePage = new MainGooglePage();
    private final ResultGooglePage resultGooglePage = new ResultGooglePage();
    private final PaginationPage paginationPage = new PaginationPage();
    private final ImagesGooglePage imagesGooglePage = new ImagesGooglePage();
    String querySelenideJava = "Selenide Java";


    @DisplayName("Проверка получения результата запросов")
    @Test
    public void checkSearchResultTest() {

        logger.info("Открывается страница, в поле поиска вводится запрос");
        mainGooglePage.enterSearchQuery(querySelenideJava);
        assertAll(
                () -> assertTrue(resultGooglePage.resultsPageLoaded(), "Страница результатов не загрузилась"),
                () -> assertTrue(resultGooglePage.resultContainsText("Selenide", 10), "Список не содержит слово 'Selenide'")
        );
    }


    @DisplayName("Проверка пагинации")
    @Test
    public void checkPaginationTest() {

        logger.info("Открывается страница, в поле поиска вводится запрос");
        mainGooglePage.enterSearchQuery(querySelenideJava);

        logger.info("Переход на следующую страницу");
        resultGooglePage.goToNextPage();

        assertAll(
                () -> assertTrue(resultGooglePage.resultsPageLoaded(), "Страница результатов не загрузилась"),
                () -> assertTrue(paginationPage.checkCurrentPageNumber("2"), "Номер страницы не соответствует")
        );
    }


    @DisplayName("Проверка изображений")
    @Test
    public void checkImageTest() {

        logger.info("Открываем браузер, вводим значение, переходим на страницу результата");
        mainGooglePage.enterSearchQuery(querySelenideJava);

        logger.info("Загрузка страницы 'Картинки'");
        resultGooglePage.goToImageTab();

        assertAll(
                () -> assertTrue(imagesGooglePage.verifyImageCountGreaterThan(0), "Изображения не отображаются"),
                () -> assertTrue(imagesGooglePage.verifyFirstImage(), "Изображение не открылось в полном размере")
        );
    }


    @DisplayName("Проверка других элементов страницы")
    @Test

    public void checkPageElements() {

        logger.info("Открываем браузер, вводим значение, переходим на страницу результата");
        mainGooglePage.enterSearchQuery(querySelenideJava);

        assertAll(
                () -> assertTrue(resultGooglePage.isSearchInputVisible(), "Поле ввода не отображается"),
                () -> assertTrue(resultGooglePage.isSearchButtonVisible(), "Кнопка поиска не присутствует"),
                () -> assertTrue(resultGooglePage.isSettingsMenuVisible(), "Меню не отображается")
        );
    }
}

