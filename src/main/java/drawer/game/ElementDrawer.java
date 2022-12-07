package drawer.game;

import ScreenLoader.ScreenLoader;

public interface ElementDrawer<T> {
    void draw(T element, ScreenLoader screen);
}
