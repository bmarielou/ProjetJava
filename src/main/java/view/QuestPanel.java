package view;

import controller.TaskQuestController;
import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QuestPanel extends JPanel {

    private TaskQuestController controller;

    private PlayerPanel playerPanel;

    private DefaultListModel<String> listModel;

    private JList<String> questList;

    private JButton addButton;
    private JButton deleteButton;
    private JButton completeButton;

    public QuestPanel(
            TaskQuestController controller,
            PlayerPanel playerPanel
    ) {

        this.controller = controller;
        this.playerPanel = playerPanel;

        setLayout(new BorderLayout(10,10));

        setBorder(
                new EmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        JLabel title =
                new JLabel(
                        "📜 Liste des quêtes"
                );

        title.setFont(
                title.getFont()
                        .deriveFont(
                                Font.BOLD,
                                20f
                        )
        );

        add(title, BorderLayout.NORTH);

        listModel =
                new DefaultListModel<>();

        questList =
                new JList<>(listModel);

        questList.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        add(
                new JScrollPane(
                        questList
                ),
                BorderLayout.CENTER
        );

        JPanel buttons =
                new JPanel();

        addButton =
                new JButton("➕ Ajouter");

        completeButton =
                new JButton("✅ Terminer");

        deleteButton =
                new JButton("🗑 Supprimer");

        buttons.add(addButton);
        buttons.add(completeButton);
        buttons.add(deleteButton);

        add(
                buttons,
                BorderLayout.SOUTH
        );

        addButton.addActionListener(
                e -> addQuest()
        );

        completeButton.addActionListener(
                e -> completeQuest()
        );

        deleteButton.addActionListener(
                e -> deleteQuest()
        );

        refreshList();
    }

    private void addQuest() {

        String title =
                JOptionPane.showInputDialog(
                        this,
                        "Titre de la quête"
                );

        if(title == null
                || title.isBlank()) {
            return;
        }

        String description =
                JOptionPane.showInputDialog(
                        this,
                        "Description"
                );

        String xpText =
                JOptionPane.showInputDialog(
                        this,
                        "XP gagnée"
                );

        int xp =
                Integer.parseInt(xpText);

        String[] options = {
                "Daily",
                "OneTime"
        };

        String type =
                (String)
                        JOptionPane.showInputDialog(
                                this,
                                "Type de quête",
                                "Nouvelle quête",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options,
                                options[0]
                        );

        Quest quest;

        if("Daily".equals(type)) {

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

        controller.addQuest(quest);

        refreshList();
    }

    private void completeQuest() {

        int index =
                questList.getSelectedIndex();

        if(index == -1) {
            return;
        }

        controller.completeQuest(index);

        refreshList();

        playerPanel.refresh();
    }

    private void deleteQuest() {

        int index =
                questList.getSelectedIndex();

        if(index == -1) {
            return;
        }

        controller.removeQuest(index);

        refreshList();
    }

    public void refreshList() {

        listModel.clear();

        for(Quest quest :
                controller.getQuests()) {

            listModel.addElement(

                    quest.getTitle()
                            + " | "
                            + quest.getStatus()
                            + " | "
                            + quest.getXpReward()
                            + " XP"

            );
        }
    }
}