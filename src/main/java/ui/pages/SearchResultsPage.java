package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SearchResultsPage {

    private final SelenideElement filterButton;

    public SearchResultsPage() {
        this.filterButton = $(".sc-eYKchh button");
    }

    @Step("Click Filter Button")
    public SearchResultsPage filter() {
        filterButton.click();
        return new SearchResultsPage();

    }

}
