package selenite.utils.wait;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;
import java.util.function.Predicate;

public interface SelWait extends Wait<WebDriver> {
    <T> T until(SelenideElement selenideElement, Function<? super SelenideElement, T> function);
    boolean until(String locator, Predicate<String> predicate);
}
