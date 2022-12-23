package base.controller.game;

import base.Application;
import base.model.game.Elements.Towers.*;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;

import java.awt.event.KeyEvent;

public class TowerController extends GameController {
    private boolean buying;
    private Tower selectedTower;
    private boolean anySelected;

    public TowerController(Play play) {
        super(play);
        buying = false;
        anySelected = false;
    }

    public boolean isBuying() {
        return buying;
    }

    public boolean isAnySelected() {
        return anySelected;
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, Integer keyPressed, long time) {
        checkIfSelected(mousePressed, keyPressed);
        openMenu(mousePressed);
        wantsToBuy(mousePressed, mouseLocation, keyPressed);
    }

    public void wantsToBuy(Position mousePressed, Position mouseLocation, Integer keyPressed){
        if (!buying) {
            boolean buyDartMonkeyTower = mousePressed.isBetween(new Position(196 * 4, 43 * 4), new Position(208 * 4, 56 * 4));
            boolean buyTackTower = mousePressed.isBetween(new Position(210 * 4, 43 * 4), new Position(223 * 4, 56 * 4));
            boolean buyIceTower = mousePressed.isBetween(new Position(225 * 4, 43 * 4), new Position(238 * 4, 56 * 4));
            boolean buyBombTower = mousePressed.isBetween(new Position(240 * 4, 43 * 4), new Position(253 * 4, 56 * 4));

            if (buyDartMonkeyTower) {
                buying = true;
                selectedTower = new DartMonkeyTower();
            } else if (buyTackTower) {
                buying = true;
                selectedTower = new TackTower();
            } else if (buyIceTower) {
                buying = true;
                selectedTower = new IceTower();
            } else if (buyBombTower) {
                buying = true;
                selectedTower = new BombTower();
            }
        } else{
            wantsToPlace(mousePressed, mouseLocation, keyPressed);
        }
    }
    public void wantsToPlace(Position mousePressed, Position mouseLocation, Integer keyPressed){
        boolean canAfford = getModel().getPlayer().canAfford(selectedTower.price());

        if (canAfford) {
            selectedTower.select();
            getModel().setPlacingTower(selectedTower);
            place(selectedTower, mousePressed, mouseLocation, keyPressed);
        } else {
            buying = false;
        }
    }

    public void place(Tower tower, Position mousePressed, Position mouseLocation, Integer keyPressed) {
        Position notPressed = new Position(-1, -1);
        boolean placing = mousePressed.equals(notPressed) && tower.isSelected() && keyPressed != KeyEvent.VK_ESCAPE;
        boolean placed = mousePressed != notPressed && mousePressed.legalPosition(getModel().getTowers()) && keyPressed != KeyEvent.VK_ESCAPE;
        boolean stopPlacing = keyPressed == KeyEvent.VK_ESCAPE;

        if (placing) {
            tower.setPosition(mouseLocation);
        } else if (placed) {
            getModel().stopPlacingTower();
            getModel().getPlayer().spendMoney(tower.price());
            tower.stopSelecting();
            getModel().addTower(tower);
            tower.setPosition(mousePressed);
            buying = false;
        }
        else if(stopPlacing){
            getModel().stopPlacingTower();
            tower.stopSelecting();
            buying = false;
        }
    }

    public void checkIfSelected(Position mousePressed, Integer keyPressed) {
        Position nullPosition = new Position(-1, -1);
        Position terminalPosition = new Position(mousePressed.getX() / 4, mousePressed.getY() / 4);

        if(buying)return;
        for (Tower tower : getModel().getTowers()) {
            Position topLeft = new Position(tower.getPosition().getX() - 8, tower.getPosition().getY() - 8);
            Position bottomRight = new Position(tower.getPosition().getX() + 8, tower.getPosition().getY() + 6);
            boolean wantsToSelect = terminalPosition.isBetween(topLeft, bottomRight) && !anySelected;
            boolean wantsToStopSelecting = tower.isSelected() && !mousePressed.equals(nullPosition) && !terminalPosition.sell() && !terminalPosition.leftUpgrade() && !terminalPosition.rightUpgrade() || keyPressed==KeyEvent.VK_ESCAPE;

            if (wantsToSelect) {
                tower.select();
                selectedTower = tower;
                anySelected = true;
                break;
            }
            else if (wantsToStopSelecting) {
                tower.stopSelecting();
                anySelected = false;
            }
        }
    }

    public void openMenu(Position mousePressed){
        Position terminalPosition = new Position(mousePressed.getX() / 4, mousePressed.getY() / 4);

        if(anySelected){
            boolean selectedLeftUpgrade = terminalPosition.leftUpgrade() && !selectedTower.getUpgrades().hasUpgraded('L');
            boolean canAffordLeftUpgrade = getModel().getPlayer().canAfford(selectedTower.getUpgradePrice('L'));
            boolean selectedRightUpgrade = terminalPosition.rightUpgrade() && !selectedTower.getUpgrades().hasUpgraded('R');
            boolean canAffordRightUpgrade = getModel().getPlayer().canAfford(selectedTower.getUpgradePrice('R'));
            boolean selectedSell = terminalPosition.sell();

            if(selectedLeftUpgrade){
                if(canAffordLeftUpgrade) {
                    selectedTower.upgradeLeft();
                    getModel().getPlayer().spendMoney(selectedTower.getUpgradePrice('L'));
                }
            }
            else if(selectedRightUpgrade){
                if(canAffordRightUpgrade) {
                    selectedTower.upgradeRight();
                    getModel().getPlayer().spendMoney(selectedTower.getUpgradePrice('R'));
                }
            }
            else if(selectedSell){
                selectedTower.stopSelecting();
                anySelected = false;
                getModel().getPlayer().addMoney(selectedTower.getValue());
                getModel().removeTower(selectedTower);
            }
        }
    }

}

