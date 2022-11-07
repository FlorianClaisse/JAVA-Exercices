package fr.florianclaisse.TPNote2018;

public abstract class Vehicle {
    private final String name;
    private final int passengers;
    private final int speed;
    private final int kmCost;

    public Vehicle(String name, int passengers, int speed, int kmCost) {
        this.name = name;
        this.passengers = passengers;
        this.speed = speed;
        this.kmCost = kmCost;
    }

    public int nbJourneyPerDay(int distance) {
        return (this.speed * 24) / distance;
    }

    public abstract boolean compatibleWith(City c);
}
