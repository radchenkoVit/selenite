package selenite.pages;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import selenite.configuration.ConfigProperties;

@Component
@Slf4j
public abstract class MainPage<T extends MainPage> {
    protected final ConfigProperties properties;

    @Autowired
    public MainPage(ConfigProperties properties) {
        this.properties = properties;
    }

    //TODO to think
    public abstract T navigate();
    public abstract boolean isOnPage();
    public abstract boolean waitPageToLoad();
}
