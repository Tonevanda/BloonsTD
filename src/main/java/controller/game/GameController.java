package controller.game;

import base.Application;
import base.Position;
import controller.Controller;

public abstract class GameController extends Controller {
    public GameController(Arena arena) {
        super(arena);
    }
}
