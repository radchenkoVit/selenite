package selenite.utils.wait;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Lazy
@Component
public class SmartWait implements Wait<WebDriver> {
    private final FluentWait<WebDriver> wait;
    private WaitModel waitModel = new WaitModel.Builder().build();
    private WaitMode mode = WaitMode.HARD;

    public SmartWait() {
        Selenide.open("");
        wait = new FluentWait<>(WebDriverRunner.getWebDriver());
        applyWaitModel(waitModel);
    }

    public SmartWait(WaitModel waitModel) {
        wait = new FluentWait<>(WebDriverRunner.getWebDriver());
        applyWaitModel(waitModel);
    }

    @Override
    public <T> T until(Function<? super WebDriver, T> function) {
        return wait.until(function);
    }

    private void applyWaitModel(WaitModel waitModel) {
        wait.ignoreAll(waitModel.getIgnoredExceptions());
        wait.withMessage(waitModel.getMessage());
        wait.pollingEvery(waitModel.getInterval());
        wait.withTimeout(waitModel.getTimeout());
    }

}