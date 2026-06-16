package view;

import controller.TaskQuestController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    public MainFrame(
            TaskQuestController controller
    ) {

        setTitle("⚔ TaskQuest");
        setSize(1000, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE
        );

        setLayout(new BorderLayout(10, 10));

        PlayerPanel playerPanel =
                new PlayerPanel(controller);

        QuestPanel questPanel =
                new QuestPanel(
                        controller,
                        playerPanel
                );

        add(playerPanel, BorderLayout.NORTH);
        add(questPanel, BorderLayout.CENTER);

        addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosing(
                            WindowEvent e
                    ) {

                        controller.save();
                    }
                }
        );
    }
}