package states;

import drawer.Drawer;
import drawer.menu.MainMenuDrawer;
import menu.Menu;

public class MainMenuState extends State<Menu>{

    public MainMenuState(Menu model) {
        super(model);
    }
/*
    @Override
    public void drawImage() {Drawer draw = new MainMenuDrawer(getModel());}
 */
    @Override
    protected Drawer<Menu> getDrawer(){
        return new MainMenuDrawer(getModel());
    }
}
