package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class FiltersModal {


    private final SelenideElement closeButton;
    private final SelenideElement priceFromInputBox;
    private final SelenideElement priceToInputBox;
    private final SelenideElement addBeds;
    private final SelenideElement removeBeds;
    private final SelenideElement bedsValue;
    private final SelenideElement addBedrooms;
    private final SelenideElement removeBedrooms;
    private final SelenideElement bedRoomsValue;
    private final SelenideElement addBathrooms;
    private final SelenideElement removeBathrooms;
    private final SelenideElement bathRoomsValue;
    private final SelenideElement beachFrontCheckbox;
    private final SelenideElement beachFrontInputLocator;
    private final SelenideElement swimmingPoolCheckbox;
    private final SelenideElement swimmingPoolInputLocator;
    private final SelenideElement freeWiFiCheckbox;
    private final SelenideElement freeWiFiInputLocator;
    private final SelenideElement kitchenCheckbox;
    private final SelenideElement kitchenInputLocator;
    private final SelenideElement airConditioningCheckbox;
    private final SelenideElement airConditioningInputLocator;
    private final SelenideElement washingMachineCheckbox;
    private final SelenideElement washingMachineInputLocator;
    private final SelenideElement petsAllowedCheckbox;
    private final SelenideElement petsAllowedInputLocator;
    private final SelenideElement hotTubCheckbox;
    private final SelenideElement hotTubInputlocator;
    private final SelenideElement streetParkingCheckbox;
    private final SelenideElement streetParkingInputLocator;
    private final SelenideElement suitableForChildrenCheckbox;
    private final SelenideElement suitableForChildrenInputLocator;
    private final SelenideElement clearAll;
    private final SelenideElement apply;


    public FiltersModal() {
        this.closeButton =  $(".sc-jHcXXw button");
        this.priceFromInputBox =  $(".sc-jffHpj:nth-child(1) .sc-dkuGKe");
        this.priceToInputBox =  $(".sc-jffHpj:nth-child(2) .sc-dkuGKe");
        this.addBeds =  $(".sc-hBezlf:nth-child(6) .sc-iGkqmO");
        this.removeBeds =  $(".sc-hBezlf:nth-child(6) .sc-eXuyPJ");
        this.bedsValue =  $(".sc-hBezlf:nth-child(6) .sc-gkCoMD");
        this.addBedrooms =  $(".sc-hBezlf:nth-child(7) .sc-iGkqmO");
        this.removeBedrooms =  $(".sc-hBezlf:nth-child(7) .sc-eXuyPJ");
        this.bedRoomsValue =  $(".sc-hBezlf:nth-child(7) .sc-gkCoMD");
        this.addBathrooms =  $(".sc-hBezlf:nth-child(8) .sc-iGkqmO");
        this.removeBathrooms =  $(".sc-hBezlf:nth-child(8) .sc-eXuyPJ");
        this.bathRoomsValue =  $(".sc-hBezlf:nth-child(8) .sc-gkCoMD");
        this.beachFrontCheckbox =  $x("//span[text()='Beach front']");
        this.beachFrontInputLocator = $x("//span[text()='Beach front']/ancestor::label/input");
        this.swimmingPoolCheckbox =  $x("//span[text()='Swimming pool']");
        this.swimmingPoolInputLocator = $x("//span[text()='Swimming pool']/ancestor::label/input");
        this.freeWiFiCheckbox =  $x("//span[text()='Free WiFi']");
        this.freeWiFiInputLocator = $x("//span[text()='Free WiFi']/ancestor::label/input");
        this.kitchenCheckbox =  $x("//span[text()='Kitchen']");
        this.kitchenInputLocator = $x("//span[text()='Kitchen']/ancestor::label/input");
        this.airConditioningCheckbox =  $x("//span[text()='Air conditioning']");
        this.airConditioningInputLocator = $x("//span[text()='Air conditioning']/ancestor::label/input");
        this.washingMachineCheckbox =  $x("//span[text()='Washing Machine']");
        this.washingMachineInputLocator = $x("//span[text()='Washing Machine']/ancestor::label/input");
        this.petsAllowedCheckbox =  $x("//span[text()='Pets allowed']");
        this.petsAllowedInputLocator = $x("//span[text()='Pets allowed']/ancestor::label/input");
        this.hotTubCheckbox =  $x("//span[text()='Hot tub']");
        this.hotTubInputlocator = $x("//span[text()='Hot tub']/ancestor::label/input");
        this.streetParkingCheckbox =  $x("//span[text()='Street parking']");
        this.streetParkingInputLocator = $x("//span[text()='Street parking']/ancestor::label/input");
        this.suitableForChildrenCheckbox =  $x("//span[text()='Suitable for children']");
        this.suitableForChildrenInputLocator = $x("//span[text()='Suitable for children']/ancestor::label/input");
        this.clearAll =  $("b");
        this.apply = $(".sc-giAqHp:nth-child(2)");
    }

    @Step("Click Close Button")
    public FiltersModal closeFilters() {
        Allure.step("Click Search Button", () ->  closeButton.click());
        return new FiltersModal();
    }

    @Step("Add Min Value")
    public FiltersModal addMinValue(String value) {
        priceFromInputBox.click();
        priceFromInputBox.setValue(value);
        return this;
    }

    @Step("Add Max Value")
    public FiltersModal addMaxValue(String value) {
        priceToInputBox.click();
        priceToInputBox.setValue(value);
        return this;
    }

    public FiltersModal addBeds(int amountOfBeds) {
        for (int i = 0; i < amountOfBeds; i++) {
            addBeds.click();
        }
        return this;
    }

    @Step("Remove Beds")
    public FiltersModal removeBeds(int amountOfBeds) {
        for (int i = 0; i < amountOfBeds; i++) {
            removeBeds.click();
        }
        return this;
    }

    @Step("Add Bedrooms")
    public FiltersModal addBedrooms(int amountOfBedrooms) {
        for (int i = 0; i < amountOfBedrooms; i++) {
            addBedrooms.click();
        }
        return this;
    }

    @Step("Remove Bedrooms")
    public FiltersModal removeBedrooms(int amountOfBedrooms) {
        for (int i = 0; i < amountOfBedrooms; i++) {
            removeBedrooms.click();
        }
        return this;
    }

    @Step("Add Bathrooms")
    public FiltersModal addBathrooms(int amountOfBathrooms) {
        for (int i = 0; i < amountOfBathrooms; i++) {
            addBathrooms.click();
        }
        return this;
    }

    @Step("Remove Bathrooms")
    public FiltersModal removeBathrooms(int amountOfBathrooms) {
        for (int i = 0; i < amountOfBathrooms; i++) {
            removeBathrooms.click();
        }
        return this;
    }

    @Step("Select Beachfront")
    public FiltersModal selectBeachfront() {
        beachFrontCheckbox.click();
        return this;
    }

    @Step("Select Swimming Pool")
    public FiltersModal selectSwimmingPool() {
        swimmingPoolCheckbox.click();
        return this;
    }

    @Step("Select FreeWifi")
    public FiltersModal selectFreeWifi() {
        freeWiFiCheckbox.click();
        return this;
    }

    @Step("Select Kitchen")
    public FiltersModal selectKitchen() {
        kitchenCheckbox.click();
        return this;
    }

    @Step("Select Air Conditioning")
    public FiltersModal selectAirConditioning() {
        airConditioningCheckbox.click();
        return this;
    }

    @Step("Select WashingMachine")
    public FiltersModal selectWashingMachine() {
        washingMachineCheckbox.click();
        return this;
    }

    @Step("Select Pets Allowed")
    public FiltersModal selectPetsAllowed() {
        petsAllowedCheckbox.click();
        return this;
    }

    @Step("Select Hot Tub")
    public FiltersModal selectHotTub() {
        hotTubCheckbox.click();
        return this;
    }

    @Step("Select Street Parking")
    public FiltersModal selectStreetParking() {
        streetParkingCheckbox.click();
        return this;
    }

    @Step("Select Suitable For Children")
    public FiltersModal selectSuitableForChildren() {
        suitableForChildrenCheckbox.click();
        return this;
    }

    @Step("Select All Amenities")
    public FiltersModal selectAllAmenities() {
        beachFrontCheckbox.click();
        swimmingPoolCheckbox.click();
        freeWiFiCheckbox.click();
        kitchenCheckbox.click();
        airConditioningCheckbox.click();
        washingMachineCheckbox.click();
        petsAllowedCheckbox.click();
        hotTubCheckbox.click();
        streetParkingCheckbox.click();
        suitableForChildrenCheckbox.click();
        return this;
    }

    @Step("Clear All Filters")
    public FiltersModal selectClearAll() {
        clearAll.click();
        return this;
    }

    @Step("Apply Filters")
    public FiltersModal selectApply() {
        apply.click();
        return this;
    }
}