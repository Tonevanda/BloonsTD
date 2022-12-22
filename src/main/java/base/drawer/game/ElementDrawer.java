package base.drawer.game;

import base.ScreenLoader.ScreenLoader;

public interface ElementDrawer<T> {
    void draw(T element, ScreenLoader screen);
}
