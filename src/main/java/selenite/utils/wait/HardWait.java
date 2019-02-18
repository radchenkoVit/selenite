package selenite.utils.wait;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class HardWait extends CommonWait {

    @Override
    public <T> T until(Function<? super WebDriver, T> function) {
        return wait.until(function);
    }

    public <T> Optional<T> until(SelenideElement selenideElement, Function<? super SelenideElement, T> function) {
        System.out.println("Trigged hard Wait");
        return Optional.of(wait.until(webDriver -> function.apply(selenideElement)));
    }

    public boolean until(String locator, Predicate<String> predicate) {
        System.out.println("Trigged soft Wait");
        wait.until(webDriver -> predicate.test(locator));
        return true;
    }
}
