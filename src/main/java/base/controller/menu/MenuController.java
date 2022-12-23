package base.controller.menu;

import base.Application;
import base.controller.Controller;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;
import base.model.menu.Menu;
import base.states.GameState;

import java.awt.event.KeyEvent;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu){
        super(menu);
    }
    @Override
    public void step(Application application, Position mousePressed, Position mouseLocation, Integer keyPressed, long time){
        boolean pressedPlay = mousePressed.isBetween(new Position(69 * 4, 73 * 4), new Position(186 * 4, 107 * 4));
        boolean pressedQuit =mousePressed.isBetween(new Position(373,453), new Position(653,553));
        boolean pressedEsc = keyPressed == KeyEvent.VK_ESCAPE;

        if (pressedPlay){
            application.setState(new GameState(new Play()));
        }
        else if(pressedQuit || pressedEsc){
            application.setState(null);
        }
    }
}
