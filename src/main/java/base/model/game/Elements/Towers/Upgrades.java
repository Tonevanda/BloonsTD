package base.model.game.Elements.Towers;

public class Upgrades {
    int left;
    int right;

    public Upgrades(){
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
        if (left < 1){
            left++;
            return true;
        }
        return false;
    }
    public boolean upgradeRight(){
        if(right < 1){
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


    public boolean hasUpgraded(char side){
        switch(side){
            case 'L': if(getLeft() == 1){
                return true;
            }
            break;
            case 'R': if(getRight() == 1){
                return true;
            }
            break;
        }
        return false;
    }
}
