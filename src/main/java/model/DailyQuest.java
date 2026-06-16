package model;

import java.time.LocalDate;

public class DailyQuest extends Quest {

    private LocalDate lastReset;

    public DailyQuest(String title,
                      String description,
                      int xpReward) {

        super(title, description, xpReward);

        lastReset = LocalDate.now();
    }

    @Override
    public String getType() {
        return "Daily";
    }

    public void resetIfNeeded() {

        if(!lastReset.equals(LocalDate.now())) {

            status = QuestStatus.TODO;

            lastReset = LocalDate.now();
        }
    }
}
    

