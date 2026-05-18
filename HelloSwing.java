import javax.swing.*;
 
public class HelloSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          JFrame frame = new JFrame("Hello Swing");
          JButton btn = new JButton("Cliquer ici");
          btn.addActionListener(e ->
            JOptionPane.showMessageDialog(
              frame, "Bonjour, monde !"));
          frame.add(btn);
          frame.setSize(320, 200);
          frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
        });
    }
}