package util.helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;


public interface JavaScriptActions {

    default void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Selenide.sleep(2000);
    }
}
