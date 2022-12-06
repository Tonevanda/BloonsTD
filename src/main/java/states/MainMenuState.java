package states;

import controller.Controller;
import controller.menu.MenuController;
import drawer.Drawer;
import drawer.menu.MainMenuDrawer;
import model.menu.Menu;

public class MainMenuState extends State<Menu>{

    public MainMenuState(Menu menu){
        super(menu);
    }
    @Override
    public Controller<Menu> getController(){
        return new MenuController(getContext());
    }
    @Override
    public Drawer<Menu> getDrawer() {
        return new MainMenuDrawer(getContext());
    }
}
