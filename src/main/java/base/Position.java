package base;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private int y;
    private int x;
    private List<Position> path = new ArrayList<>();

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void createPath(){
        for(int i = -30; i < 49; i++){
            path.add(new Position(i, 48));
        }
        for(int i = 48; i > 15; i--){
            path.add(new Position(49, i));
        }
        for(int i = 50; i < 98; i++){
            path.add(new Position(i, 16));
        }
        for(int i = 17; i < 81; i++){
            path.add(new Position(97, i));
        }
        for(int i = 96; i > 16; i--){
            path.add(new Position(i, 80));
        }
        for(int i = 81; i < 113; i++){
            path.add(new Position(17, i));
        }
        for(int i = 18; i < 162; i++){
            path.add(new Position(i, 112));
        }
        for(int i = 111; i > 63; i--){
            path.add(new Position(161, i));
        }
        for(int i = 160; i > 128; i--){
            path.add(new Position(i, 64));
        }
        for(int i = 63; i > 31; i--){
            path.add(new Position(129, i));
        }
        for(int i = 130; i < 162; i++){
            path.add(new Position(i, 32));
        }
        for(int i = 31; i > -30; i--){
            path.add(new Position(161, i));
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isInRange(Position pos, int radius){
        return Math.pow(x - pos.getX(), 2) + Math.pow(y - pos.getY(), 2) < Math.pow(radius, 2);
    }

    public Position getNextPosition(){
        createPath();
        Position pos = new Position(x,y);
        for(int i = 0; i < path.size()-1;i++){
            if(path.get(i).equals(pos)){
                return(path.get(i+1));
            }
        }
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return this.x == p.getX() && this.y == p.getY();
    }

}
