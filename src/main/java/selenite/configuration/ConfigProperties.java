package selenite.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@PropertySource("application.properties")
public class ConfigProperties {

    @Value("${login.url}")
    private String loginUrl;
}
