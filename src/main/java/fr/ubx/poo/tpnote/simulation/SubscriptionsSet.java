package fr.ubx.poo.tpnote.simulation;


import fr.ubx.poo.tpnote.subscription.FamilySubscription;
import fr.ubx.poo.tpnote.subscription.Subscription;

public class SubscriptionsSet {

    private Subscription[] subscriptions;
    private int currentIndex;
    private static final int size = 10;

    public SubscriptionsSet() {
        this.subscriptions = new Subscription[size];
        this.currentIndex = 0;
    }

    public boolean addSubscription(Subscription subscription) {
        if (this.currentIndex >= size) {
            return false;
        }

        this.subscriptions[this.currentIndex] = subscription;
        this.currentIndex++;
        return true;
    }

    public double getMeanAnnualCostPerUser() {
        double totalPrice = 0;
        int totalUser = 0;

        for (int i = 0; i < this.currentIndex; i++) {
            totalPrice += this.subscriptions[i].getCost();
            if (this.subscriptions[i] instanceof FamilySubscription) {
                FamilySubscription fam = (FamilySubscription) this.subscriptions[i];
                totalUser += fam.getNbUsers();
            } else { totalUser += 1; }
        }

        return (totalPrice * 12) / totalUser;
    }

    @Override
    public String toString() {
        StringBuilder phrase = new StringBuilder("Subscriptions info :\n" +
            "- total number : " + this.currentIndex + "\n" +
            "- mean cost per user and per year : " + this.getMeanAnnualCostPerUser() + "\n");

        for (int i = 0; i < this.currentIndex; i++) {
            phrase.append(this.subscriptions[i].toString()).append("\n");
        }

        return phrase.toString();
    }
}
