package fr.florianclaisse.TD6.Models;

import java.lang.reflect.Field;

import static fr.florianclaisse.TD6.Models.Entity.*;

public class GridRepoVar implements GridRepo {

    private final Entity[][] sample1 = {
        {GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND, GROUND, GROUND},
        {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND},
        {GROUND, GROUND, ROCK, CRACK, GROUND, GROUND, BIGROCK, GROUND, GROUND},
        {GROUND, ROCK, GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND},
        {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
        {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, CRACK, GROUND},
        {GROUND, DUST, GROUND, DUST, GROUND, GROUND, GROUND, GROUND, GROUND},
        {GROUND, GROUND, GROUND, CRACK, GROUND, DUST, BIGROCK, GROUND, GROUND},
        {GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
    };

    private final Entity[][] sample2 = {
        {GROUND, ROCK, DUST, ROCK, GROUND},
        {GROUND, CRACK, BIGROCK, CRACK, DUST},
        {GROUND, CRACK, CRACK, GROUND, BIGROCK},
        {ROCK, DUST, DUST, GROUND, DUST}
    };

    @Override
    public Grid load(String name) {
        Entity[][] entities = this.getEntities(name);
        if (entities == null) return null;

        Grid grid = new Grid(entities[0].length, entities.length);

        for (int y = 0; y < entities.length; y++) {
            for (int x = 0; x < entities[0].length; x++) {
                grid.set(x, y, entities[y][x]);
            }
        }

        return grid;
    }

    @Override
    public String export(Grid grid) {
        StringBuilder string = new StringBuilder();

        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                string.append(grid.get(x, y).getCode());
            }
            string.append("x");
        }
        System.out.println(string);
        return string.toString();
    }

    private Entity[][] getEntities(String name) {
        try {
            Field field = this.getClass().getDeclaredField(name);
            return (Entity[][]) field.get(this);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return null;
        }
    }
}
