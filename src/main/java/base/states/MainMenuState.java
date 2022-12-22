package base.states;

import base.model.controller.Controller;
import base.model.controller.menu.MenuController;
import base.drawer.Drawer;
import base.drawer.menu.MainMenuDrawer;
import base.model.menu.Menu;

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
