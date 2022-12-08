package controller.game;


import base.Play;
import controller.Controller;

public abstract class GameController extends Controller<Play> {
    public GameController(Play play) {
        super(play);
    }
}
