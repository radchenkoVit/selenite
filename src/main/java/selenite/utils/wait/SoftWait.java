package selenite.utils.wait;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class SoftWait extends CommonWait {

    @Override
    public <T> T until(SelenideElement selenideElement, Function<? super SelenideElement, T> function) {
        try {
            return wait.until(driver -> function.apply(selenideElement));
        } catch (TimeoutException e) {
            return null;
        }
    }

    @Override
    public boolean until(String locator, Predicate<String> predicate) {
        System.out.println("Trigged soft Wait");
        try {
            return wait.until(driver -> predicate.test(locator));
        } catch (Exception e) {
            System.out.println("Trigged soft Wait EXCEPTION");
            return false;
        }
    }

    @Override
    public <T> T until(Function<? super WebDriver, T> function) {
        System.out.println("Trigged soft Wait");
        try {
            return wait.until(function);
        } catch (Exception e) {
            System.out.println("Trigged soft Wait EXCEPTION");
            return null;
        }
    }
}
