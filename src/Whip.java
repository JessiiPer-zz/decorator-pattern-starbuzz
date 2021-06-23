public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super();
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }
}
