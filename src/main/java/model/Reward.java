package model;

public class Reward {

    private int levelRequired;
    private String title;

    public Reward(int levelRequired, String title) {
        this.levelRequired = levelRequired;
        this.title = title;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public String getTitle() {
        return title;
    }
}
