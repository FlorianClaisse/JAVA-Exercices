package fr.florianclaisse.TD5.Models;

public enum Entity {
    ROCK('R'),
    BIGROCK('B'),
    GROUND('G'),
    CRACK('C'),
    DUST('D');

    private final char code;

    Entity(char c) { this.code = c; }

    public char getCode() { return this.code; }

    public static Entity fromCode(char c) throws GridException {
        for (Entity entity : values()) {
            if (entity.getCode() == c)
                return entity;
        }
        System.out.println(c);
        throw new GridException("invalid entity code");
    }
}
