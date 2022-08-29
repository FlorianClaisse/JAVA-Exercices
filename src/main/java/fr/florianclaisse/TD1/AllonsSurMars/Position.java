package fr.florianclaisse.TD1.AllonsSurMars;

public class Position {
    double x;
    double y;

    Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void deplacement(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    void deplacement(double delta) {
        this.deplacement(delta, delta);
    }

    double distance(Position cible) {
        return Math.sqrt(Math.pow(this.x - cible.x, 2) + Math.pow(this.y - cible.y, 2));
    }

    void afficher() {
        System.out.println("Position{" + "x=" + x + ", y=" + y + '}');
    }
}
