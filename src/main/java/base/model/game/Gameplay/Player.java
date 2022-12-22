package base.model.game.Gameplay;

public class Player {
    private int money;
    private int lives;

    public Player(){
        money = 500;
        lives = 100;
    }

    public int getMoney(){
        return money;
    }
    public int getLives(){return lives;}

    public void addMoney(int value){
        money += value;
    }

    public void spendMoney(int value){
        money -= value;
    }

    public void loseHearts(int hearts){
        lives -= hearts;
    }
}
