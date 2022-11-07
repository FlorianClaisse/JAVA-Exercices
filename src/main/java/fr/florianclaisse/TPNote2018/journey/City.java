package fr.florianclaisse.TPNote2018;

public class City {
    private final String name;
    private final boolean station;

    public City(String name, boolean station) {
        this.name = name;
        this.station = station;
    }

    public boolean getStation() { return this.station; }
}
