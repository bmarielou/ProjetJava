package model;

public abstract class Quest {
    protected String title;
    protected String description;
    protected int xpReward;
    protected QuestStatus status;

    public Quest(String title, String description, int xpReward) {
        this.title = title;
        this.description = description;
        this.xpReward = xpReward;
        this.status = QuestStatus.TODO; 
    }
    // getters et setters ici
}
