package selenite.pages.dependPage;

import static java.lang.String.format;

public abstract class ProfilePage {

    protected abstract String getProfileInput();

    public ProfilePage fillProfile() {
        System.out.println(format("Fill data to profile input: %s", getProfileInput()));
        return this;
    }
}
