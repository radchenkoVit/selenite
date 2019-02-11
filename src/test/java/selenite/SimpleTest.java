package selenite;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import selenite.configuration.ConfigProperties;
import selenite.pages.LoginPage;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleTest extends TestRunner {
    @Autowired private LoginPage loginPage;
    @Autowired private ConfigProperties properties;

    @Test
    public void test() {
        loginPage
                .navigate()
                .sayHello();

        System.out.println(properties.getLoginUrl());
    }
}
