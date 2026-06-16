package view;

import controller.TaskQuestController;
import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel levelLabel;
    private JLabel titleLabel;
    private JProgressBar xpBar;

    private TaskQuestController controller;

    public PlayerPanel(
            TaskQuestController controller
    ) {

        this.controller = controller;

        setLayout(
                new GridLayout(4, 1, 5, 5)
        );

        setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        nameLabel = new JLabel();
        levelLabel = new JLabel();
        titleLabel = new JLabel();

        xpBar = new JProgressBar();

        add(nameLabel);
        add(levelLabel);
        add(titleLabel);
        add(xpBar);

        refresh();
    }

    public void refresh() {

        Player player =
                controller.getPlayer();

        nameLabel.setText(
                "👤 Joueur : "
                        + player.getName()
        );

        levelLabel.setText(
                "⭐ Niveau : "
                        + player.getLevel()
        );

        titleLabel.setText(
                "🏆 Titre : "
                        + player.getTitle()
        );

        xpBar.setMaximum(
                player.getLevel() * 100
        );

        xpBar.setValue(
                player.getCurrentXP()
        );

        xpBar.setString(
                player.getCurrentXP()
                        + " XP"
        );

        xpBar.setStringPainted(true);
    }
}