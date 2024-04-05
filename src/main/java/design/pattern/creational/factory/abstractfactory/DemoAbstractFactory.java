package design.pattern.creational.factory.abstractfactory;

import javafx.util.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DemoAbstractFactory {
    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeADrink();
        drink.consume();
    }

}

interface HotDrink{
    void consume();
}

class Tea implements HotDrink{

    @Override
    public void consume() {
        System.out.println("This tea is delicious :)");
    }

}

class Coffee implements HotDrink{

    @Override
    public void consume() {
        System.out.println("This coffee is delicious :)");
    }

}

interface HotDrinkFactory{
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory{

    @Override
    public HotDrink prepare(int amount) {
        System.out.println(
            "Put in tea bag, boil water, pour "
            + amount + "ml, add lemon, enjoy!"
        );
        return new Tea();
    }

}

class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println(
            "Grind some beans, boil water, pour "
            + amount + "ml, add cream, add sugar, enjoy!"
        );
        return new Coffee();
    }
}

class HotDrinkMachine{
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() throws Exception{
        Set<Class<? extends HotDrinkFactory>> types =
            new Reflections("design.pattern.creational.factory.abstractfactory")
                .getSubTypesOf(HotDrinkFactory.class);
        for(Class<? extends HotDrinkFactory> type : types){
            namedFactories.add(new Pair<>(
                type.getSimpleName().replace("Factory", ""),
                type.getDeclaredConstructor().newInstance()
            ));
        }
    }

    public void printNamedFactories(){
        for(Pair<String, HotDrinkFactory> namedFactory : namedFactories){
            System.out.println(namedFactory.getKey());
            System.out.println(namedFactory.getValue());
        }
    }

    public HotDrink makeADrink() throws Exception{
        System.out.println("Available drinks: ");
        display();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s;
            int i, amount;
            if((s = reader.readLine()) != null
                && (i = Integer.parseInt(s)) >= 0
                && (i < namedFactories.size())){
                    System.out.println("Specify Amount: ");
                    s = reader.readLine();
                    try{
                        if(s != null && (amount = Integer.parseInt(s)) > 0){
                            return namedFactories.get(i).getValue().prepare(amount);
                        }
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
            }
            System.out.print("\u001B[31m");
            System.out.println("Incorrect input, try again.");
            System.out.print("\u001B[0m");
            display();
        }
    }

    private void display() {
        for(int i = 0; i < namedFactories.size(); i++){
            Pair<String, HotDrinkFactory> item = namedFactories.get(i);
            System.out.println("" + i + ": " + item.getKey());
        }
    }
}
