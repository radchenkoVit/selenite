package selenite.utils;

import com.codeborne.selenide.WebDriverRunner;

public class BrowserInfo {

    private BrowserInfo() {
        throw new UnsupportedOperationException("Can not create browser info class object");
    }

    public static void browserState() {
        if (WebDriverRunner.getWebDriver() != null) {
            try {
                //TODO: display somewhere this info
            } catch (Exception e) {
                //if smth happed bad - print
            }
        }
    }
}
