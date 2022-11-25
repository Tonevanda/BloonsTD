package Monkey;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface Towers {
    public void setPosition(Position pos);
    public Position getPosition();
    public void draw(TextGraphics graphics);
    public int getRange();
    public int getValue();
    public int price();
    public Upgrades getUpgrades();
    public boolean upgradeLeft();
    public boolean upgradeRight();
    public Position getRadius();
}
