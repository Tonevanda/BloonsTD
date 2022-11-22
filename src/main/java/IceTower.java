import com.googlecode.lanterna.graphics.TextGraphics;

public class IceTower implements Towers{
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value; // valor de venda

    IceTower(){
        range = 100;
        value = 680;
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

    public int getRange(){
        return range;
    }

    public int getValue(){
        return value;
    }

    public int price() {
        return 850;
    }

    public void upgradeLeft() { //mais quantidade de slow//
        upgrades.upgradeLeft();
        if(upgrades.left == 1){
            value += 360;
        }
        else if(upgrades.left == 2){
            value += 400;
        }
    }

    public void upgradeRight() { //mais range de slow//
        upgrades.upgradeRight();
        if(upgrades.right == 1){
            range+=100;
            value+=240;
        }
        if(upgrades.right == 2){
            range+=150;
            value+=280;
        }
    }
}
