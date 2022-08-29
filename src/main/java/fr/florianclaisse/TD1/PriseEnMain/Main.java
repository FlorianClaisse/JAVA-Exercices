package fr.florianclaisse.TD1.PriseEnMain;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        for (String value : args) {
            System.out.print(value + " ");
        }

        System.out.println();

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }
}
