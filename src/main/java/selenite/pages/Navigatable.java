package selenite.pages;

public interface Navigatable<T extends Navigatable> {
    T navigate();
}
