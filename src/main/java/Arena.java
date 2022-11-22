import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    //private List<Coin> coins;
    private List<Monster> monsters;
    public int getWidth(){return width;}
    public int getHeight(){return height;}

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        //this.coins = createCoins();
        this.monsters = createMonsters();
    }
    public void draw(TextGraphics newTextGraphics) {
        newTextGraphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        newTextGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(newTextGraphics);

        for (Wall wall : walls)
            wall.draw(newTextGraphics);
        /*
        for (Coin coin : coins)
            coin.draw(newTextGraphics);
        */
        for(Monster monster: monsters)
            monster.draw(newTextGraphics);
    }
    public void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        moveMonsters();
        switch(key.getKeyType()){
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());
        }
    }

    private void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
        //retrieveCoins();
    }
    private boolean canHeroMove(Position position){
        for (Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    /*
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }
    private void retrieveCoins() {
        for(Coin coin : coins){
            if(hero.getPosition().equals(coin.getPosition())){
                coins.remove(coin);
                break;
            }
        }
    }*/
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }
    public void moveMonsters(){
        for(Monster monster: monsters){
            Position pos = monster.move();
            if (canHeroMove(pos)) monster.setPosition(pos);
        }
    }
    public boolean verifyMonsterCollisions(){
        for(Monster monster : monsters){
            if(hero.getPosition().equals(monster.getPosition())){
                return true;
            }
        }
        return false;
    }
}
