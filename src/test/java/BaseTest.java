import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static constants.BaseTestConstants.BASE_URL;
import static constants.BaseTestConstants.BROWSER_CHROME;


public class BaseTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = BROWSER_CHROME;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void setUp() {
        open(BASE_URL);
    }

    @AfterEach
    public void closeDriver() {
        closeWebDriver();
    }
}
