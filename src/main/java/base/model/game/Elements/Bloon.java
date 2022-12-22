package base.model.game.Elements;

import base.model.game.Elements.Towers.Towers;
import base.model.game.Gameplay.Position;

public class Bloon{
    private Position position;
    private int layers;
    private int type;
    private int waitBeforeMove;
    private long lastMovement;
    private boolean hard = false;
    /*
     * 1: red
     * 2: blue
     * 3: green
     * 4: yellow
     * 5: pink
     * 6: hard
     */

    public Bloon(String color){
        position = new Position(-30,48);
        switch(color){
            case "red": layers = 1; type =1; waitBeforeMove = 0; break;
            case "blue": layers = 2; type = 2; waitBeforeMove = 0;break;
            case "green": layers = 3; type = 3; waitBeforeMove = 0;break;
            case "yellow": layers = 4; type = 4; waitBeforeMove = 0;break;
            case "pink": layers = 5; type = 5; waitBeforeMove = 0;break;
            case "hard": layers = 6; type = 6; hard = true; waitBeforeMove = 0;break;
        }
    }

    public int getWaitBeforeMove(){
        return waitBeforeMove;
    }

    public boolean canMove(long time){
        if(time - lastMovement > waitBeforeMove){
            lastMovement=time;
            return true;
        }
        return false;
    }
    public void setPosition(Position newPos){
        position = newPos;
    }

    public Position getPosition(){
        return position;
    }
    public int getLayers(){
        return layers;
    }
    public int getType(){
        return type;
    }

    public void pop(Towers tower){
        if(hard){
            if(tower.canPopHard()){
                layers--;
                hard = false;
            }
        }
        else{
            layers -= tower.getPoppingPower();
        }
    }

    public String getColorFile(){
        switch(layers){
            case 1: return "bloons/redBloonPixel";
            case 2: return "bloons/blueBloonPixel";
            case 3: return "bloons/greenBloonPixel";
            case 4: return "bloons/yellowBloonPixel";
            case 5: return "bloons/pinkBloonPixel";
            case 6: return "bloons/hardBloonPixel";
            default: return "";
        }
    }
}
