package fr.florianclaisse.TD5.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GridRepoStringRLE implements GridRepo {

    @Override
    public Grid load(String string) {
        // Decompression
        StringBuilder array = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                System.out.println(string.charAt(i));
                for (int repeat = 0; repeat < Integer.parseInt(String.valueOf(string.charAt(i))) - 1; repeat++) {
                    array.append(string.charAt(i - 1));
                }
            } else { array.append(string.charAt(i)); }
        }

        return new Grid(10, 10);
    }

    @Override
    public String export(Grid grid) {
        return null;
    }
}
