package selenite.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;

public class SmartWait implements Wait<WebDriver> {
    private final FluentWait<WebDriver> wait;
    private final WebDriver driver = WebDriverRunner.getWebDriver();

    public SmartWait() {
        wait = new FluentWait<>(driver);
        $("").waitUntil(Condition.exist, 5000).text();
    }

    @Override
    public <T> T until(Function<? super WebDriver, T> function) {
        return wait.until(function);
    }

    public void until(Supplier<Boolean> supplier) {
        wait.until((s) -> supplier.get());
    }

    public void until() {

    }

    private Condition condition = new Condition("name") {
        @Override
        public boolean apply(Driver driver, WebElement element) {
            return element.isDisplayed();
        }
    };

}