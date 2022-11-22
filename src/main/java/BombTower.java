import com.googlecode.lanterna.graphics.TextGraphics;

public class BombTower implements Towers{
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value; // valor de venda

    BombTower(){
        range = 200;
        value = 720;
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
        return 900;
    }

    public void upgradeLeft() { //mais range de impacto da bomba
        upgrades.upgradeLeft();
        if(upgrades.left == 1){
            //range = 150; bigger boom range
            value += 520;
        }
        else if(upgrades.left == 2){
            //range = 200; bigger boom range
            value += 640;
        }
    }

    public void upgradeRight() { //mais range
        upgrades.upgradeRight();
        if(upgrades.right == 1){
            range += 100;
            value += 200;
        }
        else if(upgrades.right == 2){
            range += 100;
            value += 300;
        }
    }
}
