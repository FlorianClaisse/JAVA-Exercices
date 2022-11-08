package fr.ubx.poo.tpnote.subscription;

public class FamilySubscription extends Subscription  {

    private int nbUsers;
    private final int nbUsersMax;
    private final static double cost = 18.0;

    public FamilySubscription(String name, int nbUsersMax) {
        super(name);
        this.nbUsers = 0;
        this.nbUsersMax = nbUsersMax;
    }

    public int addUsers(int usersToAdd) {
        if (this.nbUsers + usersToAdd > this.nbUsersMax) {
            int userAdded = this.nbUsersMax - this.nbUsers;
            this.nbUsers += userAdded;
            return userAdded;
        }

        this.nbUsers += usersToAdd;
        return usersToAdd;
    }

    public int addUser() {
        return this.addUsers(1);
    }

    @Override
    public double getCost() { return cost; }

    @Override
    public int getNbUsers() { return this.nbUsers; }

    @Override
    public String toString() {
        return "Family Subscription [cost(month)=" + this.getCost() + "," + super.toString()
            + ", nb users=" + this.nbUsers + "]";
    }
}