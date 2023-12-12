package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;
import static util.Waits.waitForPageLoading;

@Getter
public class HeaderPage {


    private final SelenideElement allListingsLink;

    public HeaderPage() {
        this.allListingsLink = $("a.sc-hGwcmR.hHCTxF[href='/all-listings']");
    }

    @Step("Click All Listings")
    public HeaderPage allListings() {
        allListingsLink.click();
        waitForPageLoading(10);
        return new HeaderPage();
    }

}
