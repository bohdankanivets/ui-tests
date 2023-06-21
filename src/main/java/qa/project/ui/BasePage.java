package qa.project.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public static final String BASE_URL = "https://rozetka.com.ua/";
    public static SelenideElement btnCart = $(".header-actions__item--cart .header__button");
    public static SelenideElement inputSearch = $("input.search-form__input");


}
