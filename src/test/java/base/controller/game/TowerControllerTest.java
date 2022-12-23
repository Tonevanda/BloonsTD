package base.controller.game;

import base.Application;
import base.model.game.Elements.Towers.Tower;
import base.model.game.Elements.Towers.Upgrades;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Player;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TowerControllerTest {
    Play play;
    TowerController towerController;
    List<Tower> towers;
    Position position;

    @BeforeEach
    void setUp(){
        play = mock(Play.class);
        towerController = new TowerController(play);
        towers = new ArrayList<>();
        when(play.getPlayer()).thenReturn(mock(Player.class));
        when(play.getTowers()).thenReturn(towers);
        position = mock(Position.class);
        when(position.legalPosition(towers)).thenReturn(true);
    }

    @Test
    void step(){
        Application app = Mockito.mock(Application.class);
        Position pos = new Position(197 * 4, 45 * 4);
        assertFalse(towerController.isBuying());
        towerController.step(app, pos, pos, -1, 1);
        assertTrue(towerController.isBuying());
    }

    @Test
    public void wantsToBuyandPlaceDartMonkeyTower(){
        assertFalse(towerController.isBuying());
        Position pos = new Position(197 * 4, 45 * 4);
        towerController.wantsToBuy(pos, pos, -1);
        assertTrue(towerController.isBuying());

        when(play.getPlayer().canAfford(250)).thenReturn(true);
        Position nullPos = new Position(-1,-1);
        towerController.wantsToBuy(pos, pos, -1);
        assertTrue(towerController.isBuying());
        towerController.wantsToPlace(nullPos,nullPos,-1);
        assertTrue(towerController.isBuying());

        towerController.wantsToPlace(position,position,-1);
        assertFalse(towerController.isBuying());
        verify(play, times(1)).stopPlacingTower();
        verify(play, times(1)).addTower(any(Tower.class));
    }

    @Test
    public void buyTackTower(){
        assertFalse(towerController.isBuying());
        Position pos = new Position(211 * 4, 44 * 4);
        towerController.wantsToBuy(pos, pos, -1);
        assertTrue(towerController.isBuying());
    }

    @Test
    public void buyIceTower(){
        assertFalse(towerController.isBuying());
        Position pos = new Position(226 * 4, 44 * 4);
        towerController.wantsToBuy(pos, pos, -1);
        assertTrue(towerController.isBuying());
    }
    @Test
    public void buyBombTower(){
        assertFalse(towerController.isBuying());
        Position pos = new Position(241 * 4, 44 * 4);
        towerController.wantsToBuy(pos, pos, -1);
        assertTrue(towerController.isBuying());
    }

    @Test
    public void selectAndUnselect(){
        Position pos = new Position(10,10);
        Tower tower = mock(Tower.class);
        when(tower.getPosition()).thenReturn(pos);
        towers.add(tower);

        assertFalse(towerController.isAnySelected());
        Position x4Pos = new Position(40, 40);
        towerController.checkIfSelected(x4Pos, -1);
        assertTrue(towerController.isAnySelected());

        Position nullPos = new Position(-1,-1);
        towerController.checkIfSelected(nullPos, KeyEvent.VK_ESCAPE);
        assertFalse(towerController.isAnySelected());
    }

    @Test
    void OpenMenu(){
        Position pos = new Position(10,10);
        Tower tower = mock(Tower.class);
        when(tower.getPosition()).thenReturn(pos);
        Upgrades upgrades = mock(Upgrades.class);
        when(tower.getUpgrades()).thenReturn(upgrades);
        when(upgrades.hasUpgraded(anyChar())).thenReturn(false);
        when(upgrades.upgradeLeft()).thenReturn(true);
        when(upgrades.upgradeRight()).thenReturn(true);
        towers.add(tower);

        assertFalse(towerController.isAnySelected());
        Position x4Pos = new Position(40, 40);
        towerController.checkIfSelected(x4Pos, -1);
        assertTrue(towerController.isAnySelected());

        Position leftUpgrade = new Position(197*4,83*4);
        towerController.openMenu(leftUpgrade);
        assertTrue(towerController.isAnySelected());

        Position RightUpgrade = new Position(226*4,83*4);
        towerController.openMenu(RightUpgrade);
        assertTrue(towerController.isAnySelected());

        Position sell = new Position(202*4, 130*4);
        towerController.openMenu(sell);
        assertFalse(towerController.isAnySelected());

        verify(play, times(7)).getPlayer();
    }
}
