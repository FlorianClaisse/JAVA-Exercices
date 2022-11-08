package fr.ubx.poo.tpnote.subscription;

public enum SubscriptionLevel {
    PREMIUM(15.0),
    STANDARD(11.0),
    STUDENT(9.0);

    private final double cost;

    SubscriptionLevel(double cost) {
        this.cost = cost;
    }

    public double getCost() { return this.cost; }
}
