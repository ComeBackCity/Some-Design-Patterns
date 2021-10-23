package Problem1;

class VanillaShake extends shakeBuilder{

    public VanillaShake(boolean lactosefree, String topping, int topPrice) {
        this.name = "Vanilla Shake";
        this.lactosefree = lactosefree;
        this.topping = topping;
        this.topPrice = topPrice;
        this.Shake = new shake("Vanilla Shake");
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
        Shake.add(new component("Vanilla Flavoring",0));
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
            Shake.setPrice(190 + 60 + topPrice);
        else
            Shake.setPrice(190 + topPrice);
    }

    @Override
    public shake getShake() {
        return Shake;
    }


}
