package Problem1;

import java.util.LinkedList;

public class shake {
    String name;
    LinkedList<component> ingredients;
    int Price;

    public shake(String name) {
        this.name = name;
        this.ingredients = new LinkedList<component>();
    }

    public shake(String name, LinkedList<component> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<component> getIngredients() {
        return ingredients;
    }

    public void setIngredients(LinkedList<component> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void add(component e){
        ingredients.addLast(e);
    }


    public void show(){
        System.out.println(name+ "\t" + Price);
        for ( int i=0; i < ingredients.size(); i++)
            System.out.println(ingredients.get(i));
    }
}
