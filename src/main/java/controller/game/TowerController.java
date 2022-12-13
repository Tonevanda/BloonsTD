package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.game.Elements.Towers.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TowerController extends GameController {
    private boolean buying;
    private Towers selectedTower;
    private boolean anySelected;

    public TowerController(Play play) {
        super(play);
        buying = false;
        anySelected = false;
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, Integer keyPressed, long time) {
        checkIfSelected(mousePressed, keyPressed);
        openMenu(mousePressed);
        if (!buying) {
            if (mousePressed.isBetween(new Position(196 * 4, 43 * 4), new Position(208 * 4, 56 * 4))) {
                buying = true;
                selectedTower = new DartMonkeyTower();
            } else if (mousePressed.isBetween(new Position(210 * 4, 43 * 4), new Position(223 * 4, 56 * 4))) {
                buying = true;
                selectedTower = new TackTower();
            } else if (mousePressed.isBetween(new Position(225 * 4, 43 * 4), new Position(238 * 4, 56 * 4))) {
                buying = true;
                selectedTower = new IceTower();
            } else if (mousePressed.isBetween(new Position(240 * 4, 43 * 4), new Position(253 * 4, 56 * 4))) {
                buying = true;
                selectedTower = new BombTower();
            }
        } else {
            if (getModel().getPlayer().getMoney() >= selectedTower.price()) {
                selectedTower.select();
                getModel().setPlacingTower(selectedTower);
                place(selectedTower, mousePressed, mouseLocation, keyPressed);
            } else {
                buying = false;
            }
        }
    }

    public void place(Towers tower, Position mousePressed, Position mouseLocation, Integer keyPressed) {
        Position notPressed = new Position(-1, -1);
        if (mousePressed.equals(notPressed) && tower.isSelected() && keyPressed != KeyEvent.VK_ESCAPE) {
            tower.setPosition(mouseLocation);
        } else if (mousePressed != notPressed && mousePressed.legalPosition(getModel().getTowers()) && keyPressed != KeyEvent.VK_ESCAPE) {
            getModel().stopPlacingTower();
            getModel().getPlayer().spendMoney(tower.price());
            tower.stopSelecting();
            getModel().addTower(tower);
            tower.setPosition(mousePressed);
            buying = false;
        }
        else if(keyPressed == KeyEvent.VK_ESCAPE){
            getModel().stopPlacingTower();
            tower.stopSelecting();
            buying = false;
        }
    }

    public void checkIfSelected(Position mousePressed, Integer keyPressed) {
        Position nullPosition = new Position(-1, -1);
        Position terminalPosition = new Position(mousePressed.getX() / 4, mousePressed.getY() / 4);
        if(buying)return;
        for (Towers tower : getModel().getTowers()) {
            Position topLeft = new Position(tower.getPosition().getX() - 8, tower.getPosition().getY() - 8);
            Position bottomRight = new Position(tower.getPosition().getX() + 8, tower.getPosition().getY() + 6);
            if (terminalPosition.isBetween(topLeft, bottomRight) && !anySelected) {
                tower.select();
                selectedTower = tower;
                anySelected = true;
                break;
            }
            else if (tower.isSelected() && !mousePressed.equals(nullPosition) && !terminalPosition.sell() && !terminalPosition.leftUpgrade() && !terminalPosition.rightUpgrade() || keyPressed==KeyEvent.VK_ESCAPE) {
                tower.stopSelecting();
                anySelected = false;
            }
        }
    }

    public void openMenu(Position mousePressed){
        Position terminalPosition = new Position(mousePressed.getX() / 4, mousePressed.getY() / 4);
        if(anySelected){
            if(terminalPosition.leftUpgrade() && !selectedTower.hasUpgraded('L')){
                if(getModel().getPlayer().getMoney()>= selectedTower.getUpgradePrice('L')) {
                    selectedTower.upgradeLeft();
                    getModel().getPlayer().spendMoney(selectedTower.getUpgradePrice('L'));
                }
            }
            else if(terminalPosition.rightUpgrade() && !selectedTower.hasUpgraded('R')){
                if(getModel().getPlayer().getMoney()>=selectedTower.getUpgradePrice('R')) {
                    selectedTower.upgradeRight();
                    getModel().getPlayer().spendMoney(selectedTower.getUpgradePrice('R'));
                }
            }
            else if(terminalPosition.sell()){
                selectedTower.stopSelecting();
                anySelected = false;
                getModel().getPlayer().addMoney(selectedTower.getValue());
                getModel().removeTower(selectedTower);
            }
        }
    }

}

