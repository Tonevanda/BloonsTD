package base.model.game.Gameplay;

import base.model.game.Elements.Towers.Tower;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private int y;
    private int x;
    private final List<Position> path = new ArrayList<>();

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

    public boolean isBetween(Position positionA, Position positionB){
        return ((x <= Math.max(positionA.getX(), positionB.getX()) && x >= Math.min(positionA.getX(), positionB.getX()))
                && (y <= Math.max(positionA.getY(), positionB.getY()) && y >= Math.min(positionA.getY(), positionB.getY())));
    }

    public boolean legalPosition(List<Tower> towers){
        Position curPos = new Position((x+8)/4,(y+8)/4);
        createPath();
        Position topLeftPos = new Position(714/4,10/4);
        Position bottomRightPos = new Position(1015/4,570/4);
        boolean insideBuyMenu = curPos.isBetween(topLeftPos, bottomRightPos);

        if(insideBuyMenu) return false;

        for(Position pos : path){
            topLeftPos = new Position(pos.getX()-7, pos.getY()-5);
            bottomRightPos = new Position(pos.getX()+22, pos.getY()+23);
            boolean insidePath = curPos.isBetween(topLeftPos, bottomRightPos);

            if(insidePath) return false;
        }
        for(Tower tower : towers){
            topLeftPos = new Position(tower.getPosition().getX()-15, tower.getPosition().getY()-13);
            bottomRightPos = new Position(tower.getPosition().getX()+15, tower.getPosition().getY()+13);
            boolean insideAnotherTower = curPos.isBetween(topLeftPos, bottomRightPos);

            if(insideAnotherTower) return false;
        }
        return true;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isInRange(Position pos, int radius){
        return Math.pow((x+8) - pos.getX(), 2) + Math.pow((y+8) - pos.getY(), 2) <= Math.pow(radius, 2);
    }
    public boolean sell(){
        Position curPos = new Position(x,y);
        Position sellTop = new Position(201, 129);
        Position sellBot = new Position(245,137);
        if(curPos.isBetween(sellTop, sellBot)) return true;
        return false;
    }

    public boolean leftUpgrade(){
        Position curPos = new Position(x,y);
        Position leftUpgradeTop = new Position(196,82);
        Position leftUpgradeBot = new Position(221,127);
        boolean between = curPos.isBetween(leftUpgradeTop, leftUpgradeBot);
        if(between) return true;
        return false;
    }

    public boolean rightUpgrade(){
        Position curPos = new Position(x,y);
        Position rightUpgradeTop = new Position(225,82);
        Position rightUpgradeBot = new Position(250,127);
        if(curPos.isBetween(rightUpgradeTop,rightUpgradeBot)) return true;
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
