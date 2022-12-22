package base.controller.game;


import base.controller.Controller;
import base.model.game.Gameplay.Play;

public abstract class GameController extends Controller<Play> {
    public GameController(Play play) {
        super(play);
    }
}
