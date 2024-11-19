import java.util.*;

public class Purse {

    private Map<Denomination, Integer> cash;

    public Purse(List<Denomination> currency){

        this.cash = new HashMap<Denomination, Integer>();
        for(Denomination d: currency){
            this.cash.put(d, 0);
        }
    }

    //Add cash to our purse
    public void add(Denomination type, int num){
        this.cash.put(type, this.cash.get(type) + num);
    }

    //Remove cash from our purse
    public void remove(Denomination type, int num){
        if (this.cash.get(type) >= num){
            this.cash.put(type, this.cash.get(type) - num);
        }
        else{
            System.out.println("Not enough cash to remove");
        }
    }

    //Show the value in the purse
    public double getValue(){
        double sum = 0;
        for(Map.Entry<Denomination, Integer> entry : this.cash.entrySet()){
            sum += entry.getValue() * entry.getKey().amt();
        }
        return sum;
    }

    public String toString() {
        String amtString = "";
        for(Map.Entry<Denomination, Integer> entry : this.cash.entrySet()){
            amtString += entry.getKey().name() + ": " + entry.getValue() + "\n";
        }
        return amtString;
    }
}