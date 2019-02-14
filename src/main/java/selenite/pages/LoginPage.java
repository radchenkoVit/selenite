package selenite.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import selenite.configuration.ConfigProperties;
import selenite.utils.wait.SmartWait;

import static com.codeborne.selenide.Selenide.$;

@Component
@Slf4j
public class LoginPage implements Navigatable {
    private static final String PAGE_ELEMENT = "";

    protected final ConfigProperties properties;
    private final SmartWait smartWait;

    @Autowired
    public LoginPage(ConfigProperties properties, SmartWait smartWait) {
        this.properties = properties;
        this.smartWait = smartWait;
    }

    @Step("Navigate to login page")
    public LoginPage navigate() {
        Selenide.open(properties.getLoginUrl());
        return this;
    }

    public LoginPage sayHello(){
        log.info("Say Hello");
        System.out.println("From console method: Say Hello");
        return this;
    }

    public boolean isOnPage() {
        return $(PAGE_ELEMENT).is(Condition.appear);
    }

    public boolean waitPageToLoad() {
        return smartWait.until(webDriver -> $("body").is(Condition.appear));
    }
}
