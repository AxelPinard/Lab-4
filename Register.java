import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

    public Purse makeChange(double amt) {

         List<Denomination> currencys = new ArrayList<Denomination>();

        currencys.add(new Denomination("Hundred-Note", 100.00, "Note",
                "Images/hundred_note.png"));
        currencys.add(new Denomination("Twenty-Note", 20.00, "Note",
                "Images/twenty_note.png"));
        currencys.add(new Denomination("Ten-Note", 10.00, "Note",
                "Images/ten_note.png"));
        currencys.add(new Denomination("Five-Note", 5.00, "Note",
                "Images/five_note.png"));
        currencys.add(new Denomination("One-Note", 1.00, "Note",
                "Images/one_note.png"));
        currencys.add(new Denomination("Quarter", 0.25, "Coin",
                "Images/quarter.png"));
        currencys.add(new Denomination("Dime", 0.10, "Coin",
                "Images/dime.png"));
        currencys.add(new Denomination("Nickel", 0.05, "Coin",
                "Images/nickel.png"));
        currencys.add(new Denomination("Penny", 0.01, "Coin",
                "Images/penny.png"));



        // Instantiate purse object
        Purse purse = new Purse(currencys);

        // Convert amt to cents for easier processing
        int cents = (int) Math.round(amt * 100.00);

        for(Denomination denom: currencys) {

            purse.add(currencys.get(currencys.indexOf(denom)), (int) (cents / (denom.amt() * 100)));
            cents = cents % (int)(denom.amt() * 100);
        }

        return purse;
    }

    public static void main(String[] args) {
        System.out.print("Enter the amount of change:");
        var scanner = new Scanner(System.in);

        // Convert input to double
        double amt = Double.parseDouble(scanner.nextLine());

        // Create register object
        Register register = new Register();

        // Create purse object
        Purse purse = register.makeChange(amt);

        // Print the contents of the purse
        System.out.println(purse);
    }
}