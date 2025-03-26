package web;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PaginationPage {

    private final SelenideElement currentPageNumber = $x("//td[@class='YyVfkd NKTSme']/text()[normalize-space()='2']");


    public boolean checkCurrentPageNumber(String number) {
        currentPageNumber.shouldBe(visible).shouldHave(text(number));
        return true;
    }
}
