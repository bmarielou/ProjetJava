
import com.formdev.flatlaf.FlatDarkLaf;
import controller.TaskQuestController;
import model.Player;
import view.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    new FlatDarkLaf()
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Player player = new Player("Marie");

        TaskQuestController controller =
                new TaskQuestController(player);

        MainFrame frame =
                new MainFrame(controller);

        frame.setVisible(true);
    }
}