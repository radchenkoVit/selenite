package selenite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import selenite.configuration.ConfigProperties;
import selenite.configuration.SelenideConfig;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = SelenideConfig.class)
public class TestRunner {
    @Autowired protected ConfigProperties properties;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public static void tearDown() {

    }
}
