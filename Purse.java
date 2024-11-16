import java.util.*;

public class Purse {

    private Map<Denomination, Integer> cash;

    public Purse(){
        this.cash = new HashMap<Denomination, Integer>();
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

    public String toString(){
        StringBuilder amtString = new StringBuilder();
        for(Map.Entry<Denomination, Integer> entry : this.cash.entrySet()){
            amtString.append(entry.getKey().name()).append(": ").append(entry.getValue()).append("\n");
        }
        return amtString.toString();
    }

}