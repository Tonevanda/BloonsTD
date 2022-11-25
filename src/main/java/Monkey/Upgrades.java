package Monkey;

public class Upgrades {
    int left;
    int right;

    Upgrades(){
        left = 0;
        right = 0;
    }

    public int getLeft(){
        return left;
    }
    public int getRight(){
        return right;
    }

    public boolean upgradeLeft(){
        if (left < 2){
            left++;
            return true;
        }
        return false;
    }
    public boolean upgradeRight(){
        if(right < 2){
            right++;
            return true;
        }
        return false;
    }


}
