package base.model.game.Elements;

import base.model.game.Elements.Towers.Tower;
import base.model.game.Gameplay.Position;

public class Bloon{
    private Position position;
    private int layers;
    private int type;
    private boolean hard = false;

    public Bloon(String color){
        position = new Position(-30,48);
        switch(color){
            case "red": layers = 1; type =1; break;
            case "blue": layers = 2; type = 2;break;
            case "green": layers = 3; type = 3;break;
            case "yellow": layers = 4; type = 4; break;
            case "pink": layers = 5; type = 5; break;
            case "hard": layers = 6; type = 6; hard = true;break;
        }
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
    public boolean isHard(){return hard;}

    public void pop(Tower tower){
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
