package qa.project;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static qa.project.ui.BasePage.BASE_URL;
import static qa.project.ui.BasePage.inputSearch;

public class FilterTest {

    @Test
    public void checkFilter() {
        open(BASE_URL);
        inputSearch.setValue("iphone 13").pressEnter();
        $x("//a[@data-id='iPhone 13']").shouldHave(
                attributeMatching("class", ".*checkbox-filter__link--checked.*"));
        $x("//a[@data-id='Rozetka']").click();
        $x("//a[@class='catalog-selection__link' and text()=' Rozetka ']").shouldBe(visible);
        $x("//p[contains(@class, 'catalog-selection__label')]").shouldHave(text("7"));
    }
}
