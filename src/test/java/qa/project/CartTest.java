package qa.project;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static qa.project.ui.BasePage.BASE_URL;
import static qa.project.ui.BasePage.btnCart;
import static qa.project.ui.BasePage.inputSearch;
import static qa.project.ui.CardPopup.emptyStateTitle;

public class CartTest {

    @Test
    public void checkCartAfterAddingAndDeletingProduct() {
        open(BASE_URL);
        btnCart.click();
        emptyStateTitle.shouldHave(text("Кошик порожній"));
        $("button.modal__close").click();
        inputSearch.setValue("iphone").pressEnter();
        $x("/descendant::button[contains(@class, 'buy-button')][1]").hover().click();
        $("span.badge--green").shouldHave(text("1"));
        btnCart.click();
        $$("ul.cart-list").shouldHave(size(1));
        $("#cartProductActions0").click();
        $("rz-trash-icon.ng-star-inserted").click();
        emptyStateTitle.shouldHave(text("Кошик порожній"));
    }
}
