import com.googlecode.lanterna.graphics.TextGraphics;

public class TackTower implements Towers {
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value; // valor de venda

    TackTower(){
        range = 80;
        value = 320;
        upgrades = new Upgrades();
    }

    public void setPosition(Position pos) {
        coords = pos;
    }

    public Position getPosition() {
        return coords;
    }

    public void draw(TextGraphics graphics) {

    }

    public int getRange() {
        return range;
    }

    public int getValue(){
        return value;
    }

    public int price() {
        return 400;
    }

    public void upgradeLeft() { //mais attack speed
        upgrades.upgradeLeft();
        if(upgrades.left == 1){
           value += 200;
        }
        else if(upgrades.left == 2){
            value += 270;
        }
    }

    public void upgradeRight() { // mais range
        upgrades.upgradeRight();
        if(upgrades.right == 1){
            range+=100;
            value+=120;
        }
        if(upgrades.right == 2){
            range+=150;
            value+=160;
        }
    }
}
