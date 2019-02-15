package selenite.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import selenite.configuration.ConfigProperties;
import selenite.utils.wait.SelWait;

import static com.codeborne.selenide.Selenide.$;

@Component
@Slf4j
public class LoginPage implements Navigatable {
    private static final String PAGE_ELEMENT = "";

    protected final ConfigProperties properties;
    private final SelWait softWait;
    private final SelWait hardWait;

    @Autowired
    public LoginPage(ConfigProperties properties, @Qualifier("softWait") SelWait softWait, @Qualifier("hardWait") SelWait hardWait) {
        this.properties = properties;
        this.softWait = softWait;
        this.hardWait = hardWait;
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

    private static String LOCATOR = "#asdasd";

    public boolean waitPageToLoad() {
//        SmartWait softWait = SmartWait.getInstance();
        softWait.until(LOCATOR, l -> $(l).is(Condition.appear));
        hardWait.until($("body"), SelenideElement::isDisplayed);
//        String attr = softWait.until($("body"), e -> e.getAttribute("sss"));
        return softWait.until(webDriver -> $("body").is(Condition.appear));

//        return true;
    }
}
