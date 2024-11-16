import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RegisterPanel extends JPanel {
    private Register register;
    private JTextField input;
    private PursePanel changePanel;
    List<Denomination> currencyss = new ArrayList<Denomination>();

    public RegisterPanel() {
        register = new Register();

        currencyss.add(new Denomination("Hundred-Note", 100.00, "Note",
                "Images/hundred_note.png"));
        currencyss.add(new Denomination("Twenty-Note", 20.00, "Note",
                "Images/twenty_note.png"));
        currencyss.add(new Denomination("Ten-Note", 10.00, "Note",
                "Images/ten_note.png"));
        currencyss.add(new Denomination("Five-Note", 5.00, "Note",
                "Images/five_note.png"));
        currencyss.add(new Denomination("One-Note", 1.00, "Note",
                "Images/one_note.png"));
        currencyss.add(new Denomination("Quarter", 0.25, "Coin",
                "Images/quarter.png"));
        currencyss.add(new Denomination("Dime", 0.10, "Coin",
                "Images/dime.png"));
        currencyss.add(new Denomination("Nickel", 0.05, "Coin",
                "Images/nickel.png"));
        currencyss.add(new Denomination("Penny", 0.01, "Coin",
                "Images/penny.png"));

        // Prompt user to enter amount
        input = new JTextField(10);
        JPanel inputPanel = new JPanel();
        JLabel label = new JLabel("Enter Amount: $");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        inputPanel.add(label);
        inputPanel.add(input);

        // Panel displaying purse information
        changePanel = new PursePanel((List<Denomination>) currencyss);
        changePanel.setSize(500,800);
        changePanel.setBackground(Color.DARK_GRAY);
        changePanel.setForeground(Color.WHITE);
        changePanel.setFont(new Font("Arial", Font.PLAIN, 20));

        // Align register panel horizontally
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(inputPanel);
        this.add(changePanel);

        // Add ActionListener to text field when user presses Enter
        input.addActionListener(new InputListener());
    }

    // Retrieve & process input
    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double amount = Double.parseDouble(input.getText());
            Purse change = register.makeChange(amount);
            changePanel.updatePurse(change);
        }
    }
}