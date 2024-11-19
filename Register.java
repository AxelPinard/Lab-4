import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

    public List<Denomination> typesOfDenomination(){
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
        return currencys;
    }

    public Purse purseFactory(){
        Purse purse = new Purse(typesOfDenomination());
        return purse;
    }

    public Purse makeChange(double amt) {

        Purse purse = purseFactory();
        List<Denomination> currencys = typesOfDenomination();

        // Convert amt to cents for easier processing
        int cents = (int) Math.round(amt * 100.00);

        for(Denomination denom: currencys) {

            purse.add(currencys.get(currencys.indexOf(denom)), (int) (cents / (denom.amt() * 100)));
            cents = cents % (int)(denom.amt() * 100);
        }

        return purse;
    }

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        double amt;
        Register register = new Register();
        Purse purse;

        while(true) {
           System.out.print("Enter the amount of change in purse:");

           // Convert input to double
           amt = Double.parseDouble(scanner.nextLine());

           // Create purse object
           purse = register.makeChange(amt);

           // Print the contents of the purse
           System.out.println(purse);}
    }
}