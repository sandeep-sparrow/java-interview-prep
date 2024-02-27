package faang.dsa.tree;

public class TreeNodeMain {

    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hotDrinks = new TreeNode("hot");
        TreeNode coldDrinks = new TreeNode("cold");
        
        drinks.addChild(coldDrinks);
        drinks.addChild(hotDrinks);

        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");

        hotDrinks.addChild(coffee);
        hotDrinks.addChild(tea);

        TreeNode alcoholic = new TreeNode("alcoholic");
        TreeNode nonAlcoholic = new TreeNode("non-alcoholic");

        coldDrinks.addChild(alcoholic);
        coldDrinks.addChild(nonAlcoholic);

        System.out.println(drinks.print(0));
    }    
}
