package base;

public class Position {
    private int y;
    private int x;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return this.x == p.getX() && this.y == p.getY();
    }

}
