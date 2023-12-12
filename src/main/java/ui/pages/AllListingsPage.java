package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;
import util.helpers.JavaScriptActions;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static util.Waits.waitForPageLoading;
@Getter
public class AllListingsPage implements JavaScriptActions  {

    private final SelenideElement allButton;
    private final ElementsCollection listings;

    public AllListingsPage() {
        this.allButton = $(byClassName("sc-bsatvv"));
        this.listings = $$(byClassName("sc-QxirK"));
    }

    @Step("Count Listings")
    public boolean countListings() {
        int numberOfListingsOnAllLabel = Integer.parseInt(allButton.text().replaceAll("[^0-9]", ""));
        int initialCount = listings.size();

        while (true) {
            scrollToEnd();

            if (listings.size() == initialCount) {
                break;
            }

            initialCount = listings.size();
        }

        int numberOfListings = listings.size();

        Assert.assertEquals(numberOfListings, numberOfListingsOnAllLabel, "Number of listings counted does not match number of listings returned");
        return true;
    }

}
