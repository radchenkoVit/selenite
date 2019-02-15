package selenite;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import selenite.configuration.ConfigProperties;
import selenite.configuration.SelenideConfig;
import selenite.utils.soft_assert.SoftAssert;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = SelenideConfig.class)
//@ActiveProfiles(profiles = "dev")// if user with qualifaier need for running test always send parameter "-Dspring.profiles.active=qa"
public class TestRunner {
    @Autowired protected ConfigProperties properties;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        setHeadlessBrowser();

        Selenide.open("http://www.google.com");
    }

    @Before
    public void beforeSetUp() {
    }

    @After
    public void afterTearDown() {
        SoftAssert.verifyErrors();//verify errors for each test and clean them
    }

    public static void setHeadlessBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(options);

        WebDriverRunner.setWebDriver(driver);
    }

    // To get vm options property, need to send as -Dtest.prop=test, where -D${PROPERTY_NAME}=${PROPERTY_VALUE} and get by System.getProperty("")
    public static void getProp() {
        System.getProperty("");
    }

    @AfterClass
    public static void tearDown() {

    }
}
