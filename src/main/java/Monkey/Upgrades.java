package Monkey;

public class Upgrades {
    int left;
    int right;

    Upgrades(){
        left = 0;
        right = 0;
    }
    public void upgradeLeft(){
        if (left < 2){
            left++;
        }
    }
    public void upgradeRight(){
        if(right < 2){
            right++;
        }
    }


}
