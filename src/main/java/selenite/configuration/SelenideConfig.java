package selenite.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"selenite"})
public class SelenideConfig {

//    @Bean
//    public WebDriver webDriver() {
//        return WebDriverRunner.getWebDriver();
//    }
}
