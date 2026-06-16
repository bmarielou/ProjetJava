package persistence;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {

    private static final String FILE =
            "save.json";

    public static void save(Player player,
                            List<Quest> quests) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE)
                    );

            writer.write(
                    player.getName()
            );

            writer.newLine();

            for(Quest quest : quests) {

                writer.write(

                        quest.getType()
                        + ";"
                        + quest.getTitle()
                        + ";"
                        + quest.getDescription()
                        + ";"
                        + quest.getXpReward()
                        + ";"
                        + quest.getStatus()

                );

                writer.newLine();
            }

            writer.close();

        } catch(IOException e) {

            e.printStackTrace();
        }
    }

    public static List<Quest> load() {

        List<Quest> quests =
                new ArrayList<>();

        File file =
                new File(FILE);

        if(!file.exists()) {
            return quests;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            reader.readLine();

            String line;

            while(
                    (line = reader.readLine())
                            != null
            ) {

                String[] data =
                        line.split(";");

                String type =
                        data[0];

                String title =
                        data[1];

                String description =
                        data[2];

                int xp =
                        Integer.parseInt(
                                data[3]
                        );

                QuestStatus status =
                        QuestStatus.valueOf(
                                data[4]
                        );

                Quest quest;

                if(type.equals("Daily")) {

                    quest =
                            new DailyQuest(
                                    title,
                                    description,
                                    xp
                            );

                } else {

                    quest =
                            new OneTimeQuest(
                                    title,
                                    description,
                                    xp
                            );
                }

                quest.setStatus(status);

                quests.add(quest);
            }

            reader.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return quests;
    }
}