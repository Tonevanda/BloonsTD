package base.model.controller.game;


import base.model.controller.Controller;
import base.model.game.Gameplay.Play;

public abstract class GameController extends Controller<Play> {
    public GameController(Play play) {
        super(play);
    }
}
