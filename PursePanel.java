import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel(List<Denomination> currency) {
        this.purse = new Purse(currency);
        this.setLayout(null); // Initializing to null to manually position images
        this.setBackground(Color.DARK_GRAY);
        this.setPreferredSize(new Dimension(900, 600));
    }

    public void updatePurse(Purse newPurse) {
        this.purse = newPurse;
        this.removeAll(); // Remove all previous images
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String purseContents = purse.toString();

        // Separate each currency type by lines
        String[] lines = purseContents.split("\n");

        int y = 20; // Space between images (y-axis)

        for (String line : lines) {
            // Parse the quantity of the denomination from the line to ensure correct number of images are rendered
            int quantity = getQuantityFromLine(line);

            // Display text to the left of images
            g.drawString(line, 10, y + 20);

            // Determine denomination and add correct number of images
            if (line.contains("Hundred")) {
                addDenominationImages("Images/hundred_note.png", quantity, y);
            } else if (line.contains("Twenty")) {
                addDenominationImages("Images/twenty_note.png", quantity, y);
            } else if (line.contains("Ten")) {
                addDenominationImages("Images/ten_note.png", quantity, y);
            } else if (line.contains("Five")) {
                addDenominationImages("Images/five_note.png", quantity, y);
            } else if (line.contains("One")) {
                addDenominationImages("Images/one_note.png", quantity, y);
            } else if (line.contains("Quarter")) {
                addDenominationImages("Images/quarter.png", quantity, y);
            } else if (line.contains("Dime")) {
                addDenominationImages("Images/dime.png", quantity, y);
            } else if (line.contains("Nickel")) {
                addDenominationImages("Images/nickel.png", quantity, y);
            } else if (line.contains("Penn")) {
                addDenominationImages("Images/penny.png", quantity, y);
            }

            y += 75; // Update y position
        }

        this.repaint(); // Refresh display
    }

    private int getQuantityFromLine(String line) {
        // Splits strings by "x" to extract quantity
        String[] parts = line.split("x");

        // Returns quantity from line
        if (parts.length > 1)
            // parts[0] contains the quantity (ex. 2 x Ten-Notes) -- 2 is parts[0]
            return Integer.parseInt(parts[0].trim());
        else
            return 1;
    }

    private void addDenominationImages(String imagePath, int quantity, int y) {
        // Creates required number of images for each denomination
        for (int i = 0; i < quantity; i++) {
            // Creates images for denominations
            ImageIcon img = new ImageIcon(imagePath);
            img.setImage(img.getImage().getScaledInstance(90, 55, Image.SCALE_SMOOTH));

            JLabel imgLabel = new JLabel(img);

            // Position the imgLabel
            int xOffset = 200 + (i * 95);
            imgLabel.setBounds(xOffset, y, 90, 55);
            this.add(imgLabel);
        }
    }
}