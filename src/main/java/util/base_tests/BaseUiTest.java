package util.base_tests;

import org.testng.annotations.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;
import static util.ConfigurationProvider.copyFileToAllureResults;
import static util.ConfigurationProvider.setUiConfiguration;
import static util.readers.PropertiesReader.getProperty;

public class BaseUiTest {

    private static final String BROWSER_TYPE_PROPERTY = "browser.type";
    private static final String BROWSER_VERSION_PROPERTY = "browser.version";
    private static final String BROWSER_SIZE_PROPERTY = "browser.size";
    private static final String BROWSER_HEADLESS_PROPERTY = "browser.headless";
    private static final String BROWSER_TIMEOUT_PROPERTY = "browser.timeout";

    @BeforeSuite(alwaysRun = true)
    public void setEnvironmentConfiguration() {
        setUiConfiguration();
        copyFileToAllureResults();
        }


    @BeforeClass
    public void setUp() {

        browser = getProperty(BROWSER_TYPE_PROPERTY);
        browserVersion = getProperty(BROWSER_VERSION_PROPERTY);
        browserSize = getProperty(BROWSER_SIZE_PROPERTY);
        headless = Boolean.parseBoolean(getProperty(BROWSER_HEADLESS_PROPERTY));
        timeout = Long.parseLong(getProperty(BROWSER_TIMEOUT_PROPERTY));
        }


    @AfterClass(alwaysRun = true)
    public void afterTest() {
        if (webdriverContainer.hasWebDriverStarted()) {
            webdriverContainer.closeWebDriver();
        }
    }

}
