package repository;

import com.google.gson.Gson;

public class QuestRepository {
    private static final String FILE = "data/quests.json";

    public void save(List<Quest> quests) {
        // écrire la liste en JSON dans le fichier
    }

    public List<Quest> load() {
        // lire le fichier JSON et retourner la liste
    }
}