package base;


import model.game.Elements.Bloon;
import model.game.Elements.Towers.Towers;
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
        bloons = new ArrayList<>();
        startGame();
    }
    public int getRound(){
        return round;
    }

    public List<Bloon> getBloons(){return bloons;}
    public List<Towers> getTowers(){return towers;}

    public List<Bloon> bloonSender(){
        List<Bloon> sending = new ArrayList<>();

        switch(round){
            case 1:{
                bloons.add(new Bloon("red"));
                for(int i = 1; i < 10; i++) {
                    bloons.add(new Bloon("red"));
                }
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
        bloonSender();
        System.out.println("Game Started");
    }

    public boolean isAlive(){
        return player.getLives() > 0;
    }
    public Player getPlayer(){
        return player;
    }

    public boolean hasRoundEnded() {
        return bloons.isEmpty();
    }

    public void removeBloon(Bloon bloon){
        bloons.remove(bloon);
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
