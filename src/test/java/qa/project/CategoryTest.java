package qa.project;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static qa.project.ui.BasePage.BASE_URL;
import static qa.project.ui.BasePage.inputSearch;

public class CategoryTest {

    @Test
    public void checkCategory() {
        open(BASE_URL);
        inputSearch.setValue("Apple");
        $(".button_color_green").click();
        $$x("//li[contains(@class, 'portal-grid__cell')]").shouldHave(size(20));
        $x("/descendant::div[contains(@class, 'tile-cats')][1]").click();
        $("h1.catalog-heading").shouldHave(Condition.text("Apple"));
    }
}
