package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;
import static util.readers.PropertiesReader.getProperty;

@Getter
public class HomePage {

    private final SelenideElement checkIn;
    private final SelenideElement checkOut;
    private final SelenideElement searchButton;

    public HomePage() {
        this.checkIn = $(".sc-kGVuwA .sc-csTbgd");
        this.checkOut = $("sc-aiooD .sc-iJCRrE");
        this.searchButton = $(".sc-jVSGNQ button");
    }

    @Step("Open Page")
    public HomePage openPage() {
        open(getProperty("demo.domain.url"));

        return new HomePage();
    }

    @Step("Click Search")
    public HomePage search() {
        searchButton.click();
        return new HomePage();
    }

    @Step("Click CheckIn Button")
    public HomePage checkIn() {

        checkIn.click();
        return new HomePage();
    }

    public HomePage selectQueryDates() {
        LocalDate currentDate = LocalDate.now();

        ElementsCollection calendarDays = $$(By.className("CalendarDay"));
        for (SelenideElement calendarDay : calendarDays) {
            if (calendarDay.is(Condition.enabled)) {
                String dayText = calendarDay.getText();
                LocalDate availableDate = LocalDate.of(currentDate.getYear(), currentDate.getMonthValue(), Integer.parseInt(dayText));
                if (!availableDate.isBefore(currentDate)) {
                    //Check-in date
                    calendarDay.click();
                    //Check-out date
                    calendarDay.sibling(0).click();
                    break;
                }
            }
        }
        return new HomePage();
    }
}
