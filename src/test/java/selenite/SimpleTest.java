package selenite;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import selenite.categories.RegressionCategory;
import selenite.categories.SmokeCategory;
import selenite.configuration.ConfigProperties;
import selenite.pages.LoginPage;

@Slf4j
@Category({RegressionCategory.class, SmokeCategory.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleTest extends TestRunner {
    @Autowired private LoginPage loginPage;
    @Autowired private ConfigProperties properties;

    @Test
    public void test() {
        loginPage
                .navigate()
                .sayHello()
                .waitPageToLoad();

        System.out.println(properties.getLoginUrl());
    }
}
