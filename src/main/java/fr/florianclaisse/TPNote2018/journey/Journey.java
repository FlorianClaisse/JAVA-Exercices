package fr.florianclaisse.TPNote2018;

import fr.florianclaisse.TPNote2018.vehicle.Vehicle;

public class Journey {

    private final City city1;
    private final City city2;
    private final int distance;
    private final int passengerTicket;
    private Vehicle[] vehicles = new Vehicle[100];
    private int currentIndex = 0;

    public Journey(City city1, City city2, int distance, int passengerTicket) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
        this.passengerTicket = passengerTicket;
    }
}
