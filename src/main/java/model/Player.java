package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int level;
    private int currentXP;
    private int totalXP;
    private String title;

    private List<Reward> rewards;

    public Player(String name) {

        this.name = name;
        level = 1;
        currentXP = 0;
        totalXP = 0;
        title = "Débutant";

        rewards = new ArrayList<>();

        rewards.add(new Reward(5, "Aventurier"));
        rewards.add(new Reward(10, "Héros"));
        rewards.add(new Reward(20, "Légende"));
    }

    public void addXP(int xp) {

        totalXP += xp;
        currentXP += xp;

        while(currentXP >= level * 100) {

            currentXP -= level * 100;
            level++;

            updateTitle();
        }
    }

    private void updateTitle() {

        for(Reward reward : rewards) {

            if(level >= reward.getLevelRequired()) {
                title = reward.getTitle();
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public String getTitle() {
        return title;
    }
}