package controller;

import model.*;
import persistence.JsonManager;

import java.util.ArrayList;
import java.util.List;

public class TaskQuestController {

    private List<Quest> quests;

    private Player player;

    public TaskQuestController(Player player) {

        this.player = player;

        quests = new ArrayList<>();

        quests.addAll(
                JsonManager.load()
        );
    }

    public void addQuest(Quest quest) {

        quests.add(quest);
    }

    public void removeQuest(int index) {

        quests.remove(index);
    }

    public void completeQuest(int index) {

        Quest quest =
                quests.get(index);

        if(quest.getStatus()
                != QuestStatus.DONE) {

            quest.setStatus(
                    QuestStatus.DONE
            );

            player.addXP(
                    quest.getXpReward()
            );
        }
    }

    public void save() {

        JsonManager.save(
                player,
                quests
        );
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public Player getPlayer() {
        return player;
    }
}