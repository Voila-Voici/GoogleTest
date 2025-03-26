package web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainGooglePage {

    private final SelenideElement searchInputGoogle = Selenide.$x("//textarea[@name='q']");


    public void enterSearchQuery(String query) {
        searchInputGoogle.setValue(query).pressEnter();
    }
}
