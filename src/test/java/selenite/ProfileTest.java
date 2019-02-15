package selenite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import selenite.pages.dependPage.ProfilePage;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTest extends TestRunner {
    @Autowired private ProfilePage profilePage;

    @Test
    public void test() {
        profilePage.fillProfile();
    }
}
