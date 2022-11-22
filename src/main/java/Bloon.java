import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Bloon{
    private Position coords;
    private int layers;
    private int type;
    private boolean hard;

    /*
     * 1: red
     * 2: blue
     * 3: green
     * 4: yellow
     * 5: pink
     * 6: hard
     */

    public Bloon(String color){
        switch(color){
            case "red": layers = 1; type =1; break;
            case "blue": layers = 2; type = 2; break;
            case "green": layers = 3; type = 3; break;
            case "yellow": layers = 4; type = 4; break;
            case "pink": layers = 5; type = 5; break;
            case "hard": layers = 6; type = 6; hard = true; break;
        }
    }

    public Position getCoords(){
        return coords;
    }
    public int getLayers(){
        return layers;
    }

    public int getType(){
        return type;
    }

    public void pop(){
        layers--;
        // money
        // if(layers == 0) apagar
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getCoords().getX(), getCoords().getY()),"O");
    }
}
