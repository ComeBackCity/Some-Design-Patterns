package Problem1;

public abstract class shakeBuilder {

    String name ;
    boolean lactosefree;
    String topping;
    int topPrice;
    shake Shake ;

    abstract void base();
    abstract void addIngerdients();
    abstract void addToppings();
    abstract void total();
    abstract shake getShake();
}
