package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.game.Elements.Towers.DartMonkeyTower;
import model.game.Elements.Towers.Towers;

public class TowerController extends GameController{
    private boolean buying;
    private Towers placingTower;
    public TowerController(Play play){
        super(play);
        buying = false;
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, long time) {
        if(mousePressed.isBetween(new Position(10,10), new Position(50,50)) && !buying){
            buying = true;
            placingTower = new DartMonkeyTower();
        }
        else if(buying){
            if(getModel().getPlayer().getMoney()>placingTower.price()){
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
        if(mousePressed.equals(notPressed) && !tower.isPlaced()){
            System.out.println("placing");
            tower.setPosition(mouseLocation);
        }
        else if(mousePressed != notPressed && mousePressed.legalPosition()){
            getModel().stopPlacingTower();
            System.out.println("placed");
            getModel().getPlayer().spendMoney(tower.price());
            tower.Place();
            getModel().addTower(tower);
            tower.setPosition(mousePressed);
            buying = false;
        }
    }
}

