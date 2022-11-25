package Monkey;

import base.Position;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Upgrades p = (Upgrades) o;
        return this.left == p.getLeft() && this.right == p.getRight();
    }


}
