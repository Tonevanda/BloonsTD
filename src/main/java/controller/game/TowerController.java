package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.game.Elements.Towers.*;

public class TowerController extends GameController{
    private boolean buying;
    private Towers placingTower;
    public TowerController(Play play){
        super(play);
        buying = false;
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, long time) {
        if(!buying) {
            if (mousePressed.isBetween(new Position(196*4, 43*4), new Position(208*4, 56*4))) {
                buying = true;
                placingTower = new DartMonkeyTower();
            } else if (mousePressed.isBetween(new Position(210*4,43*4), new Position(223*4,56*4))) {
                buying = true;
                placingTower = new TackTower();
            } else if (mousePressed.isBetween(new Position(225*4,43*4), new Position(238*4,56*4))) {
                buying = true;
                placingTower = new IceTower();
            } else if (mousePressed.isBetween(new Position(240*4,43*4), new Position(253*4,56*4))) {
                buying = true;
                placingTower = new BombTower();
            }
        }
        else{
            if(getModel().getPlayer().getMoney()>placingTower.price()){
                placingTower.select();
                place(placingTower, mousePressed, mouseLocation);
                getModel().setPlacingTower(placingTower);
            }
            else{
                buying = false;
            }
        }
    }

    public void place(Towers tower, Position mousePressed, Position mouseLocation){
        Position notPressed = new Position(-1,-1);
        if(mousePressed.equals(notPressed) && tower.isSelected()){
            tower.setPosition(mouseLocation);
        }
        else if(mousePressed != notPressed && mousePressed.legalPosition(getModel().getTowers())){
            getModel().stopPlacingTower();
            getModel().getPlayer().spendMoney(tower.price());
            tower.stopSelecting();
            getModel().addTower(tower);
            tower.setPosition(mousePressed);
            buying = false;
        }
    }


}

