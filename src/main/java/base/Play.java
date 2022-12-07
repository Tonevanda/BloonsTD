package base;


import com.googlecode.lanterna.screen.Screen;
import model.game.Elements.Bloon;
import model.game.Elements.Towers.Towers;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Play {
    private Player player;
    private int round;
    private List<Bloon> bloons;
    private List<Towers> towers;

    public Play(){
        player = new Player();
        startGame();
    }
    public int getRound(){
        return round;
    }

    public List<Bloon> getBloons(){return bloons;}
    public List<Towers> getTowers(){return towers;}

    public List<Bloon> bloonSender(int round){
        List<Bloon> sending = new ArrayList<>();

        switch(round){
            case 1:{
                for(int i = 0; i < 14; i++) sending.add(new Bloon("red"));
                break;
            }
            case 2:{
                for(int i = 0; i<30; i++) sending.add(new Bloon("red"));
                break;
            }
            case 3:{
                for(int i = 0; i<20; i++) sending.add(new Bloon("red"));
                for(int i= 0; i<5;i++) sending.add(new Bloon("blue"));
                break;
            }
            case 4:{
                for(int i = 0; i<25;i++)sending.add(new Bloon("blue"));
                break;
            }
            case 5:{
                for(int i = 0; i<20; i++)sending.add(new Bloon("blue"));
                for(int i = 0; i<5; i++)sending.add(new Bloon("green"));
                break;
            }
            case 6:{
                for(int i = 0; i < 20; i++) sending.add(new Bloon("green"));
                break;
            }
            case 7:{
                for(int i = 0; i < 10; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("yellow"));
                break;
            }
            case 8:{
                for(int i = 0; i < 5; i++) sending.add(new Bloon("blue"));
                for(int i = 0; i < 10; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 30; i++) sending.add(new Bloon("yellow"));
                break;
            }
            case 9:{
                for(int i = 0; i < 40; i++) sending.add(new Bloon("blue"));
                for(int i = 0; i < 10; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 5; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 10:{
                for(int i = 0; i < 30; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 11:{
                for(int i = 0; i < 50; i++) sending.add(new Bloon("yellow"));
                break;
            }
            case 12:{
                for(int i = 0; i < 25; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 25; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 13:{
                for(int i = 0; i < 50; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 14:{
                for(int i = 0; i < 50; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 50; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 5; i++) sending.add(new Bloon("hard"));
                break;
            }
            case 15:{
                for(int i = 0; i<10; i++) sending.add(new Bloon("red"));
                for(int i= 0; i<10;i++) sending.add(new Bloon("blue"));
                for(int i = 0; i < 10; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("pink"));
                for(int i = 0; i < 20; i++) sending.add(new Bloon("hard"));
                break;
            }
        }
        return sending;
    }
    public void startGame(){
        round = 1;
        bloons = bloonSender(round);
        System.out.println("Game Started");
        try {
            startRound();
        }
        catch (java.io.IOException ex){
        }
    }

    public boolean isAlive(){
        if(player.getLives()>0) return true;
        return false;
    }

    public boolean hasRoundEnded(){
        if(bloons.isEmpty()){
            round++;
            return true;
        }
        return false;
    }


    public void startRound() throws IOException{
        //drawBloons();
        for(Bloon bloon : bloons){
            moveBloons(bloon);
        }
        //screen.clear();
        //draw(screen);
        //drawBloons();
        //screen.refresh();
    }

    public void moveBloons(Bloon b) throws IOException {
        //while(b.getCoords().getX() < 10){
            System.out.println("movendo");
        //}
    }

    public void popBloon() {
        for (Bloon bloon : bloons) {
            for (Towers tower : towers) {
                if (bloon.getPosition().isInRange(tower.getPosition(),tower.getRadius())) {
                    bloon.pop();
                    if (bloon.getLayers() == 0) {
                        bloons.remove(bloon);
                        break;
                    }
                }
            }
        }
    }

}
