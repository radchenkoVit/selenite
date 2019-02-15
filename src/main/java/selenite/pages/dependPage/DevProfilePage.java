package selenite.pages.dependPage;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DevProfilePage extends ProfilePage {
    @Override
    protected String getProfileInput() {
        return "DevProfilePage";
    }
}
