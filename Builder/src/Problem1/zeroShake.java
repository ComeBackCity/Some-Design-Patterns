package Problem1;

class zeroShake extends shakeBuilder{



    public zeroShake(boolean lactosefree, String topping, int topPrice) {
        this.name = "Zero Shake";
        this.lactosefree = lactosefree;
        this.topping = topping;
        this.topPrice = topPrice;
        this.Shake = new shake("Zero Shake");
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
        Shake.add(new component("Sugar Free Jello",0));
        Shake.add(new component("Sweetner",0));
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
            Shake.setPrice(240 + 60 + topPrice);
        else
            Shake.setPrice(240 + topPrice);
    }

    @Override
    public shake getShake() {
        return Shake;
    }


}
