import com.googlecode.lanterna.graphics.TextGraphics;

public class DartMonkeyTower implements Towers{

    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value; // valor de venda

    DartMonkeyTower() {
        range = 120;
        value = 100;
        upgrades = new Upgrades();
    }

    public void setPosition(Position pos) {
        coords = pos;
    }

    public Position getPosition(){
        return coords;
    }

    public void draw(TextGraphics graphics) {

    }

    public int getRange(){
        return range;
    }

    public int getValue(){
        return value;
    }

    public int price() {
        return 250;
    }

    public void upgradeLeft(){ //mais attack speed //
        upgrades.upgradeLeft();
        if(upgrades.left == 1){
            value += 168;
        }
        else if(upgrades.left == 2){
            value += 204;
        }
    }
    public void upgradeRight() { //mais range//
        upgrades.upgradeRight();
        if (upgrades.right == 1) {
            range = 150;
            value += 80;
        } else if (upgrades.right == 2) {
            range = 200;
            value += 90;
        }
    }
}
