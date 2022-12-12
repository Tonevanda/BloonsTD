package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.game.Elements.Towers.*;

import java.util.ArrayList;
import java.util.List;

public class TowerController extends GameController {
    private boolean buying;
    private Towers selectedTower;
    private List<Towers> placedTowers;
    private boolean anySelected;

    public TowerController(Play play) {
        super(play);
        placedTowers = new ArrayList<>();
        buying = false;
        anySelected = false;
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, long time) {
        checkIfSelected(mousePressed);
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
                place(selectedTower, mousePressed, mouseLocation);
                getModel().setPlacingTower(selectedTower);
            } else {
                buying = false;
            }
        }
    }

    public void place(Towers tower, Position mousePressed, Position mouseLocation) {
        Position notPressed = new Position(-1, -1);
        if (mousePressed.equals(notPressed) && tower.isSelected()) {
            tower.setPosition(mouseLocation);
        } else if (mousePressed != notPressed && mousePressed.legalPosition(getModel().getTowers())) {
            getModel().stopPlacingTower();
            getModel().getPlayer().spendMoney(tower.price());
            tower.stopSelecting();
            getModel().addTower(tower);
            tower.setPosition(mousePressed);
            buying = false;
            placedTowers.add(tower);
        }
    }

    public void checkIfSelected(Position mousePressed) {
        Position nullPosition = new Position(-1, -1);
        Position terminalPosition = new Position(mousePressed.getX() / 4, mousePressed.getY() / 4);
        for (Towers tower : placedTowers) {
            Position topLeft = new Position(tower.getPosition().getX() - 8, tower.getPosition().getY() - 8);
            Position bottomRight = new Position(tower.getPosition().getX() + 8, tower.getPosition().getY() + 6);
            if (terminalPosition.isBetween(topLeft, bottomRight) && !anySelected) {
                tower.select();
                selectedTower = tower;
                anySelected = true;
                break;
            }
            else if (tower.isSelected() && !mousePressed.equals(nullPosition)) {
                System.out.println("select out: " + mousePressed.getX() + ", " + mousePressed.getY());
                tower.stopSelecting();
                anySelected = false;
            }
        }
    }

    public void openMenu(Position mousePressed){
        Position leftUpgradeTop = new Position(100,200);
        Position leftUpgradeBot = new Position(200,300);
        if(anySelected == true){
            if(mousePressed.isBetween(leftUpgradeTop, leftUpgradeBot)){
                selectedTower.upgradeLeft();
            }
        }
    }

}

