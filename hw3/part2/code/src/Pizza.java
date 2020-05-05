public abstract class Pizza {
    public void makeCrust() {
        System.out.println("Mix flour, yeast, salt, sugar, warm water, olive oil to make a crust");
    }

    abstract void addToppings(); // subclasses need to implement this

    public void preHeatOven() {
        System.out.println("Pre heat the oven");
    }

    public void cook() {
        System.out.println("Let the pizza cook");
    }

    public void makeFromScratch() { // template method that calls all primitive operations inside of it
        makeCrust();
        addToppings();
        preHeatOven();
        cook();
    }

}
