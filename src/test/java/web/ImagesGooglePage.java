package web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class ImagesGooglePage {

    ElementsCollection images = $$x("//img[ancestor::div[@jscontroller='XW992c']]");
    SelenideElement firstImage = $x("//img[@alt='Selenide: лаконичные и стабильные UI тесты на Java']");
    SelenideElement imageIsVisible = $x("//img[@class='sFlh5c FyHeAf iPVvYb']");


    public boolean verifyImageCountGreaterThan(int minCount) {
        images.shouldHave(sizeGreaterThan(minCount), Duration.ofSeconds(10));
        return true;
    }

    public boolean verifyFirstImage() {
        firstImage.click();
        imageIsVisible.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }
}
