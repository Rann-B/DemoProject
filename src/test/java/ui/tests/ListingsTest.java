package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ui.pages.*;
import util.base_tests.BaseUiTest;

import static org.testng.Assert.assertTrue;

@Feature("Listings")
public class ListingsTest extends BaseUiTest {
    private static final HomePage homePage = new HomePage();
    private static final AllListingsPage allListingsPage = new AllListingsPage();
    private static final HeaderPage headerPage = new HeaderPage();

    @Test
    @Description("Test whether records on 'All' label matches number of listings returned on page")
    public void testCountAllListings() {

        homePage
                .openPage();
        headerPage
                .allListings();

        assertTrue(allListingsPage.countListings(),"Counts do not match");

    }
}
