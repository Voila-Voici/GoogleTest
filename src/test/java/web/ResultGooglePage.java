package web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class ResultGooglePage {

    private final SelenideElement searchInput = Selenide.$x("//textarea[@name='q']");
    private final SelenideElement searchButton = Selenide.$x("//button[@class='HZVG1b Tg7LZd']");
    private final ElementsCollection results = $$x("////h3[contains(text(), 'Selenide')]");
    private final SelenideElement nextPageButton = $x("//*[@id='pnnext']");
    private final SelenideElement imagesButton = $x("//div[@class='YmvwI' and text()='Картинки']");
    private final SelenideElement settingsButton = $x("//div[@class = 'fLciMb']");
    private final SelenideElement settingsMenu = $x("//div[@class='Lvwayc eejsDc']");


    public boolean resultsPageLoaded() {
        results.first().shouldBe(visible);
        return true;
    }

    public boolean resultContainsText(String string, int count) {
        for (SelenideElement result : results.first(count)) {
            result.shouldHave(text(string));
        }
        return true;
    }

    public void goToNextPage() {
        nextPageButton.shouldBe(visible).click();
    }

    public void goToImageTab() {
        imagesButton.shouldBe(visible).click();
    }

    public boolean isSearchInputVisible() {
        searchInput.shouldBe(visible);
        return true;
    }

    public boolean isSearchButtonVisible() {
        searchButton.shouldBe(visible);
        return true;
    }

    public boolean isSettingsMenuVisible() {
        settingsButton.shouldBe(visible).click();
        settingsMenu.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }
}
