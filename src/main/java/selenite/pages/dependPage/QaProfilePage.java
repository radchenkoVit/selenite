package selenite.pages.dependPage;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("qa")
@Component
public class QaProfilePage extends ProfilePage {
    @Override
    protected String getProfileInput() {
        return "QaProfilePage";
    }
}
