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
        for(int i = 0; i < 10; i++){
            path.add(new Position(i, 0));
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
        if((pos.getX()-radius < x && x < pos.getX()+radius) && (pos.getY()-radius < y && y < pos.getY()+radius)){
            return true;
        }
        return false;
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
