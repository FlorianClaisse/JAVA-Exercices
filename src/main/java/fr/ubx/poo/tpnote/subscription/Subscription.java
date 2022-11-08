package fr.ubx.poo.tpnote.subscription;

public abstract class Subscription {

    private final String mailAddress;

    public Subscription(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public abstract double getCost();
    public abstract int getNbUsers();

    @Override
    public String toString() {
        return " mail address=" + mailAddress; }
}
