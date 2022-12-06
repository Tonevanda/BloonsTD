package controller.game;

import base.Application;
import base.Play;
import base.Position;
import controller.Controller;

public abstract class GameController extends Controller<Play> {
    public GameController(Play play) {
        super(play);
    }
}
