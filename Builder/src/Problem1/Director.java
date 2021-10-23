package Problem1;

class Director{
    shakeBuilder myShakeBuilder;

    public void construct(shakeBuilder sb){
        myShakeBuilder = sb;
        myShakeBuilder.base();
        myShakeBuilder.addIngerdients();
        myShakeBuilder.addToppings();
        myShakeBuilder.total();
    }

}
