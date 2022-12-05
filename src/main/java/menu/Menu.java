package menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry;

    public Menu(){
        this.entries = Arrays.asList("Start", "Exit");
        currentEntry = 3;
    }

    public void startGame(){
        currentEntry = 0;
    }
    public void exitMenu(){
        currentEntry = 1;
    }

    public String getEntry(int i){
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }
}
