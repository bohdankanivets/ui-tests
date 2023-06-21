package qa.project;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static qa.project.ui.BasePage.BASE_URL;
import static qa.project.ui.BasePage.inputSearch;

public class ProductCardSizeTest {

    @Test
    public void checkProductCardSize() {
        open(BASE_URL);
        inputSearch.setValue("iphone 13").pressEnter();
        String actualSmallTileSize = $x("/descendant::div[@class='goods-tile__inner'][1]").getSize().toString();
        assertEquals(actualSmallTileSize, "(209, 458)", "Size for small tile assertion failed");
        $x("//button[@title='Крупна плитка']").click();
        $x("//button[@title='Крупна плитка']").shouldHave(attributeMatching("class", ".*button_state_active.*"));
        String actualBigTileSize = $x("/descendant::div[@class='goods-tile__inner'][1]").getSize().toString();
        assertEquals(actualBigTileSize, "(262, 527)", "Size for big tile assertion failed");
    }
}
