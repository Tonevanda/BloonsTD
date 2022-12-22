package controller;

import base.controller.game.TowerController;
import base.model.game.Elements.Towers.Towers;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Player;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TowerControllerTest {
    Play play;
    TowerController towerController;
    List<Towers> towers;
    Position position;

    @BeforeEach
    void setUp(){
        play = mock(Play.class);
        towerController = new TowerController(play);
        towers = new ArrayList<>();
        when(play.getPlayer()).thenReturn(mock(Player.class));
        position = mock(Position.class);
        when(position.legalPosition(towers)).thenReturn(true);
    }

    @Test
    public void wantsToBuyandPlace(){
        assertFalse(towerController.isBuying());
        Position pos = new Position(197 * 4, 45 * 4);
        towerController.wantsToBuy(pos, pos, -1);
        assertTrue(towerController.isBuying());

        Position nullPos = new Position(-1,-1);
        towerController.wantsToPlace(nullPos,nullPos,-1);
        assertTrue(towerController.isBuying());

        towerController.wantsToPlace(position,position,-1);
        assertFalse(towerController.isBuying());

    }


}
