package Problem1;

class coffeeShake extends shakeBuilder{

    public coffeeShake(boolean lactosefree, String topping, int topPrice) {
        this.name = "Coffee Shake";
        this.lactosefree = lactosefree;
        this.topping = topping;
        this.topPrice = topPrice;
        this.Shake = new shake("Coffee Shake");
    }


    @Override
    public void base() {
        if(lactosefree){
            component c = new component("Almond milk",60);
            Shake.add(c);
        }
        else{
            component c = new component("Milk",0);
            Shake.add(c);
        }


    }

    @Override
    public void addIngerdients() {
        Shake.add(new component("Coffee",0));
        Shake.add(new component("Jello",0));
        Shake.add(new component("Sugar",0));
    }

    @Override
    public void addToppings() {
        if (topping.equalsIgnoreCase("None")) {
            return;
        } else {
            Shake.add(new component(topping, topPrice));
        }
    }

    @Override
    public void total() {
        if (lactosefree)
            Shake.setPrice(230 + 60 + topPrice);
        else
            Shake.setPrice(230 + topPrice);
    }

    @Override
    public shake getShake() {
        return Shake;
    }


}
