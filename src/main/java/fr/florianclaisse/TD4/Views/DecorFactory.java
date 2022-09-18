package fr.florianclaisse.TD4.Views;

import fr.florianclaisse.TD4.Models.World;
import fr.florianclaisse.TD4.Models.Position;

public class DecorFactory {
    public static SpriteDecor create(Position position, int kind) {
        return switch (kind) {
            case World.DUST -> new SpriteDust(position);
            case World.ROCK -> new SpriteRock(position);
            default -> null;
        };
    }
}
