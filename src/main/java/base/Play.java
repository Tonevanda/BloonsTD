package base;


import model.game.Elements.Bloon;
import model.game.Elements.Towers.Towers;
import java.util.ArrayList;
import java.util.List;

public class Play {
    private Player player;
    private int round;
    private List<Bloon> bloons;
    private List<Towers> towers;
    private List<Towers> placingTower;

    public Play(){
        player = new Player();
        bloons = new ArrayList<>();
        towers = new ArrayList<>();
        placingTower = new ArrayList<>();
        round = 1;
        startRound();
    }
    public int getRound(){
        return round;
    }

    public List<Bloon> getBloons(){return bloons;}
    public List<Towers> getTowers(){return towers;}
    public List<Towers> getPlacingTower(){
        return placingTower;
    }
    public void setPlacingTower(Towers tower){
        placingTower.add(tower);
    }
    public void stopPlacingTower(){
        placingTower.clear();
    }

    public void bloonSender(){
        switch(round){
            case 1:{
                for(int i = 0; i < 10; i++) {
                    bloons.add(new Bloon("red"));
                }
                break;
            }
            case 2:{
                for(int i = 0; i<10; i++) bloons.add(new Bloon("red"));
                for(int i= 0; i<5;i++) bloons.add(new Bloon("blue"));
                break;
            }
            case 3:{
                for(int i= 0; i<10;i++) bloons.add(new Bloon("blue"));
                break;
            }
            case 4:{
                for(int i = 0; i<10;i++)bloons.add(new Bloon("blue"));
                for(int i = 0; i<5; i++)bloons.add(new Bloon("green"));
                break;
            }
            case 5:{
                for(int i = 0; i<15; i++)bloons.add(new Bloon("green"));
                break;
            }
            case 6:{
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("green"));
                for(int i = 0; i < 15; i++) bloons.add(new Bloon("yellow"));
                break;
            }
            case 7:{
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("yellow"));
                break;
            }
            case 8:{
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("blue"));
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("green"));
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("yellow"));
                break;
            }
            case 9:{
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("blue"));
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("yellow"));
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("pink"));
                break;
            }
            case 10:{
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("green"));
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("yellow"));
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("pink"));
                break;
            }
            case 11:{
                for(int i = 0; i < 15; i++) bloons.add(new Bloon("yellow"));
                break;
            }
            case 12:{
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("yellow"));
                for(int i = 0; i < 10; i++) bloons.add(new Bloon("pink"));
                break;
            }
            case 13:{
                for(int i = 0; i < 20; i++) bloons.add(new Bloon("pink"));
                break;
            }
            case 14:{
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("hard"));
                break;
            }
            case 15:{
                for(int i = 0; i<5; i++) bloons.add(new Bloon("red"));
                for(int i= 0; i<5;i++) bloons.add(new Bloon("blue"));
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("green"));
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("yellow"));
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("pink"));
                for(int i = 0; i < 5; i++) bloons.add(new Bloon("hard"));
                break;
            }
        }
    }
    public void startRound(){
        bloonSender();
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
    public void removeTower(Towers tower){
        towers.remove(tower);
        System.out.println("Tower removed");
    }
    public void nextRound(){
        round++;
        startRound();
    }
    public void addTower(Towers tower){
        towers.add(tower);
    }

    public void popBloon(long time, int bloonsToSend) {
        int i = 0;
        for (Towers tower : towers) {
            boolean shot = false;
            if(tower.canShoot(time)){
                while(i < bloonsToSend) {
                    Bloon bloon = bloons.get(i);
                    if (bloon.getPosition().isInRange(tower.getPosition(), tower.getRadius())) {
                        shot = true;
                        bloon.pop(tower);
                        if (bloon.getLayers() <= 0) {
                            player.addMoney(bloon.getType() * 50);
                            bloons.remove(bloon);
                            bloonsToSend--;
                            i = 0;
                        }
                        else{
                            i++;
                        }
                        if (!tower.canShootMultiple()){
                            tower.setLastShot(time);
                            return;
                        }
                    }
                    else{
                        i++;
                    }
                }
            }
            if(shot){
                tower.setLastShot(time);
            }
        }
    }

}
