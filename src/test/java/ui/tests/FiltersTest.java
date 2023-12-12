package ui.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ui.pages.FiltersModal;
import ui.pages.HomePage;
import ui.pages.SearchResultsPage;
import util.base_tests.BaseUiTest;

@Feature("Filters")
public class FiltersTest extends BaseUiTest {

    private static final HomePage homePage = new HomePage();
    private static final SearchResultsPage searchResultsPage = new SearchResultsPage();
    private static final FiltersModal filtersModal = new FiltersModal();

    @Test
    @Description("Test that Price input box is disabled if no dates selected")
    public void testPriceInputDisabled() {

        homePage
                .openPage()
                .search();
        searchResultsPage
                .filter();

        filtersModal.getPriceFromInputBox().shouldBe(Condition.disabled);
        filtersModal.getPriceToInputBox().shouldBe(Condition.disabled);

    }

    @Test
    @Description("Test that Price input box is enabled if dates selected")
    public void testPriceInputEnabled() {

        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();

        filtersModal.getPriceFromInputBox().shouldBe(Condition.enabled);
        filtersModal.getPriceToInputBox().shouldBe(Condition.enabled);

    }

    @Test
    @Description("Test initial state of Price Input Boxes")
    public void testInitialInputBoxState() {
        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();

        filtersModal.getPriceFromInputBox().shouldBe(Condition.empty);
        filtersModal.getPriceToInputBox().shouldBe(Condition.empty);
    }

    @Test
    @Description("Test Initial State Of Rooms And Beds - Buttons And Values")
    public void testInitialButtonState() {
        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();

        filtersModal.getRemoveBeds().shouldBe(Condition.disabled);
        filtersModal.getAddBeds().shouldBe(Condition.enabled);
        filtersModal.getBedsValue().shouldHave(Condition.text("0"));

        filtersModal.getRemoveBedrooms().shouldBe(Condition.disabled);
        filtersModal.getAddBedrooms().shouldBe(Condition.enabled);
        filtersModal.getBedRoomsValue().shouldHave(Condition.text("0"));

        filtersModal.getRemoveBathrooms().shouldBe(Condition.disabled);
        filtersModal.getAddBathrooms().shouldBe(Condition.enabled);
        filtersModal.getBathRoomsValue().shouldHave(Condition.text("0"));
    }

    @Test
    @Description("Test that Add Button Becomes Disabled After Adding Maximum Amount Of Beds/Bedrooms/Bathrooms")
    public void testAddButtonAfterAddingMaxSelection() {
        int maxSelection = 10;

        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();

        filtersModal.addBeds(maxSelection);
        filtersModal.getAddBeds().shouldBe(Condition.disabled);
        filtersModal.getRemoveBeds().shouldBe(Condition.enabled);

        filtersModal.addBedrooms(maxSelection);
        filtersModal.getAddBedrooms().shouldBe(Condition.disabled);
        filtersModal.getRemoveBedrooms().shouldBe(Condition.enabled);

        filtersModal.addBathrooms(maxSelection);
        filtersModal.getAddBathrooms().shouldBe(Condition.disabled);
        filtersModal.getRemoveBathrooms().shouldBe(Condition.enabled);
    }

    @Test
    @Description("Test that Add Button Becomes Enabled After Removing Beds/Bedrooms/Bathrooms")
    public void testAddButtonAfterRemovingSelection() {
        int maxSelection = 10;
        int noOfBedsToRemove = 1;

        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();

        filtersModal.addBeds(maxSelection);
        filtersModal.removeBeds(noOfBedsToRemove);
        filtersModal.getAddBeds().shouldBe(Condition.enabled);

        filtersModal.addBedrooms(maxSelection);
        filtersModal.removeBedrooms(noOfBedsToRemove);
        filtersModal.getAddBedrooms().shouldBe(Condition.enabled);

        filtersModal.addBathrooms(maxSelection);
        filtersModal.removeBathrooms(noOfBedsToRemove);
        filtersModal.getAddBathrooms().shouldBe(Condition.enabled);

    }

    @Test
    @Description("Test that Add & Remove Buttons Are Functional - Beds")
    public void testBedsSelection() {

        int noOfBedsToAdd = 3;
        int noOfBedsToRemove = 1;
        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();
        filtersModal
                .addBeds(noOfBedsToAdd)
                .removeBeds(noOfBedsToRemove);

        filtersModal.getBedsValue().shouldHave(Condition.text(String.valueOf(noOfBedsToAdd-noOfBedsToRemove)));

    }

    @Test
    @Description("Test that Add & Remove Buttons Are Functional - Bedrooms")
    public void testBedroomsSelection() {

        int noOfBedroomsToAdd = 4;
        int noOfBedroomsToRemove = 3;
        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();
        filtersModal
                .addBedrooms(noOfBedroomsToAdd)
                .removeBedrooms(noOfBedroomsToRemove);

        filtersModal.getBedRoomsValue().shouldHave(Condition.text(String.valueOf(noOfBedroomsToAdd-noOfBedroomsToRemove)));

    }

    @Test
    @Description("Test that Add & Remove Buttons Are Functional - Bathrooms")
    public void testBathroomsSelection() {

        int noOfBathroomsToAdd = 6;
        int noOfBathroomsToRemove = 3;
        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();
        filtersModal
                .addBathrooms(noOfBathroomsToAdd)
                .removeBathrooms(noOfBathroomsToRemove);

        filtersModal.getBathRoomsValue().shouldHave(Condition.text(String.valueOf(noOfBathroomsToAdd-noOfBathroomsToRemove)));

    }

    @Test
    @Description("Test initial state of amenities checkboxes")
    public void testInitialCheckboxState() {
        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();

        filtersModal.getBeachFrontCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getSwimmingPoolCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getFreeWiFiCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getKitchenCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getAirConditioningCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getWashingMachineCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getPetsAllowedCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getHotTubCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getStreetParkingCheckbox().shouldNotBe(Condition.selected);
        filtersModal.getSuitableForChildrenCheckbox().shouldNotBe(Condition.selected);
    }

    @Test
    @Description("Test Amenities Checkboxes")
    public void testAmenitiesCheckboxes() {
        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();
        filtersModal
                .selectAllAmenities();

        filtersModal.getBeachFrontInputLocator().shouldBe(Condition.checked);
        filtersModal.getSwimmingPoolInputLocator().shouldBe(Condition.checked);
        filtersModal.getFreeWiFiInputLocator().shouldBe(Condition.checked);
        filtersModal.getKitchenInputLocator().shouldBe(Condition.checked);
        filtersModal.getAirConditioningInputLocator().shouldBe(Condition.checked);
        filtersModal.getWashingMachineInputLocator().shouldBe(Condition.checked);
        filtersModal.getPetsAllowedInputLocator().shouldBe(Condition.checked);
        filtersModal.getHotTubInputlocator().shouldBe(Condition.checked);
        filtersModal.getStreetParkingInputLocator().shouldBe(Condition.checked);
        filtersModal.getSuitableForChildrenInputLocator().shouldBe(Condition.checked);

    }

    @Test
    @Description("Test that 'Clear All' button is functional")
    public void testClearAllFilters() {

        homePage
                .openPage()
                .checkIn()
                .selectQueryDates()
                .search();
        searchResultsPage
                .filter();
        filtersModal
                .addMinValue("100")
                .addMaxValue("100000")
                .addBeds(3)
                .addBedrooms(3)
                .addBathrooms(3)
                .selectAllAmenities()
                .selectClearAll();


        filtersModal.getPriceFromInputBox().shouldBe(Condition.empty);
        filtersModal.getPriceToInputBox().shouldBe(Condition.empty);
        filtersModal.getBedsValue().shouldHave(Condition.text("0"));
        filtersModal.getBedRoomsValue().shouldHave(Condition.text("0"));
        filtersModal.getBathRoomsValue().shouldHave(Condition.text("0"));
        filtersModal.getBeachFrontInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getSwimmingPoolInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getFreeWiFiInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getKitchenInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getAirConditioningInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getWashingMachineInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getPetsAllowedInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getHotTubInputlocator().shouldNotBe(Condition.checked);
        filtersModal.getStreetParkingInputLocator().shouldNotBe(Condition.checked);
        filtersModal.getSuitableForChildrenInputLocator().shouldNotBe(Condition.checked);

    }
}
