package qa.project;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.chop;
import static org.testng.Assert.assertTrue;
import static qa.project.ui.BasePage.BASE_URL;
import static qa.project.ui.BasePage.inputSearch;

public class SortingFromHigherPricesToLowerTest {

    @Test
    public void checkSortingFromHigherPricesToLower() {
        open(BASE_URL);
        inputSearch.setValue("iphone").pressEnter();
        $x("//select[contains(@class, 'select-css')]").click();
        $x("//option[text()='Від дорогих до дешевих']").click();
        $x("//div[@class='preloader']").shouldNotBe(visible);
        String actualFirstProductPrice = $x("/descendant::span[@class='goods-tile__price-value'][1]").getText();
        String actualSecondProductPrice = $x("/descendant::span[@class='goods-tile__price-value'][2]").getText();
        String actualFifthProductPrice = $x("/descendant::span[@class='goods-tile__price-value'][5]").getText();
        int convertedFirstProductPrice = parseInt(chop(actualFirstProductPrice).replace(" ", ""));
        int convertedSecondProductPrice = parseInt(chop(actualSecondProductPrice).replace(" ", ""));
        int convertedFifthProductPrice = parseInt(chop(actualFifthProductPrice).replace(" ", ""));
        assertTrue(convertedFirstProductPrice > convertedSecondProductPrice, "First product price less than second product price");
        assertTrue(convertedSecondProductPrice > convertedFifthProductPrice, "Second product price less than fifth product price");
    }
}
