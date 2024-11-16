import javax.swing.JFrame;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args) {
        // Register frame
        JFrame frame = new JFrame("MakingChange");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setBackground(Color.LIGHT_GRAY);

        // Register Panel
        RegisterPanel registerPanel = new RegisterPanel();
        frame.add(registerPanel);
        frame.setVisible(true);
    }
}