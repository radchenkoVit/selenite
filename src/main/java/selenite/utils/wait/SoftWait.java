package selenite.utils.wait;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
@Component
public class SoftWait extends CommonWait {

    @Override
    public <T> Optional<T> until(SelenideElement selenideElement, Function<? super SelenideElement, T> function) {
        try {
            return Optional.of(wait.until(driver -> function.apply(selenideElement)));
        } catch (TimeoutException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean until(String locator, Predicate<String> predicate) {
        log.info("Trigged soft Wait");
        try {
            return wait.until(driver -> predicate.test(locator));
        } catch (Exception e) {
            log.warn("LOGGER HERE");
            return false;
        }
    }

    @Override
    public <T> T until(Function<? super WebDriver, T> function) {
        log.info("Trigged soft Wait");
        try {
            return wait.until(function);
        } catch (Exception e) {
            log.warn("Trigged soft Wait EXCEPTION");
            return null;
        }
    }
}
