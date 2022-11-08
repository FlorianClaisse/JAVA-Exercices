package fr.ubx.poo.tpnote.subscription;

public class IndividualSubscription extends Subscription {

    private final SubscriptionLevel level;

    public IndividualSubscription(String name, SubscriptionLevel level) {
        super(name);
        this.level = level;
    }

    public IndividualSubscription(String name) {
        this(name, SubscriptionLevel.STANDARD);
    }

    @Override
    public double getCost() { return this.level.getCost(); }

    @Override
    public int getNbUsers() { return 1; }

    @Override
    public String toString() {
        return "Individual Subscription [cost(month)=" + this.getCost() + "," + super.toString()
            + ", nb users=" + this.getNbUsers() + "]";
    }
}