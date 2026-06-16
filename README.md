# TaskQuest

A Java Swing quest tracker that turns tasks into game-style quests. The app tracks a player profile with XP, level progress, and quest completion states.

## Features
- Create new quests with title, description, XP reward, and type
- Support for Daily quests and one-time quests
- Mark quests as complete and earn XP
- Delete quests from the list
- Player profile with level, current XP, total XP, and title
- Persistent save/load using a simple `save.json` file
- FlatLaf dark theme for a modern UI

## Requirements
- Java 21
- Maven
- Internet access to download the FlatLaf dependency on first build

## Run
1. Build the project:
   ```bash
   mvn clean compile
   ```
2. Start the application:
   ```bash
   mvn exec:java
   ```

## How to use
- Use the **Add** button to create a new quest
- Select a quest and click **Complete** to finish it and gain XP
- Select a quest and click **Delete** to remove it
- The player panel shows current level progress and title
- Closing the window saves the current quests and player state automatically

## Persistence
- Quest data and player progress are written to `save.json` in the project root
- The file stores each quest line as `type;title;description;xp;status`
- If `save.json` is missing, the app starts with an empty quest list

## Project structure
- `Main.java` — application entry point and theme setup
- `controller/TaskQuestController.java` — quest management and saving logic
- `model/` — `Quest`, `DailyQuest`, `OneTimeQuest`, `Player`, `Reward`, and `QuestStatus`
- `view/` — Swing UI components: `MainFrame`, `PlayerPanel`, and `QuestPanel`
- `persistence/JsonManager.java` — file I/O for save/load operations

## Notes
- The default player name is currently hardcoded as `Marie` in `Main.java`
- The app does not currently validate all input formats, so XP should be entered as a number
- Daily quests include a reset mechanism, but current UI handling is minimal
