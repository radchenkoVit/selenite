package selenite.utils.wait;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public abstract class CommonWait implements SelWait {
    protected final FluentWait<WebDriver> wait;
    protected WaitModel waitModel = new WaitModel.Builder().build();

    public CommonWait() {
        wait = new FluentWait<>(WebDriverRunner.getWebDriver());
        applyWaitModel(waitModel);
    }

    public CommonWait(WaitModel waitModel) {
        wait = new FluentWait<>(WebDriverRunner.getWebDriver());
        applyWaitModel(waitModel);
    }

    private void applyWaitModel(WaitModel waitModel) {
        wait.ignoreAll(waitModel.getIgnoredExceptions());
        wait.withMessage(waitModel.getMessage());
        wait.pollingEvery(waitModel.getInterval());
        wait.withTimeout(waitModel.getTimeout());
    }
}
