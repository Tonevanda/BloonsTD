package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.game.Elements.Towers.DartMonkeyTower;
import model.game.Elements.Towers.Towers;

public class TowerController extends GameController{
    public TowerController(Play play){
        super(play);
    }

    public void step(Application application, Position mousePressed, long time) {
        Position monkeyPositionTest = new Position(10,10);
        if(mousePressed.equals(monkeyPositionTest)){
            Towers dartMonkey = new DartMonkeyTower();
            if(getModel().getPlayer().getMoney() > dartMonkey.price()){
                getModel().getPlayer().spendMoney(dartMonkey.price());
                getModel().addTower(dartMonkey);
                Position testPos = new Position(100,95);
                dartMonkey.setPosition(testPos);
            }
        }
    }
}
