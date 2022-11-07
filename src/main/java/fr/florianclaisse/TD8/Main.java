package fr.florianclaisse.TD8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Point> arrayList = new ArrayList<>();
        List<Point> linkedList = new LinkedList<>();

        Point point1 = new Point(3, 4);
        Point copy = point1;
        Point point2 = new Point(3, 4);
        Point point3 = new Point(4, 5);

        arrayList.add(point1);
        arrayList.add(point2);
        arrayList.add(point3);
        arrayList.add(copy);
        System.out.println(arrayList);

        linkedList.add(point1);
        linkedList.add(point2);
        linkedList.add(point3);
        linkedList.add(copy);
        System.out.println(linkedList);

        long startTime, endTime;

        // 10,000 Linked creation
        startTime = System.nanoTime();
        var linked = createRandomLinkedList(10000, 100);
        endTime = System.nanoTime();
        System.out.println("Time for create 10,000 linked list = " + ((endTime - startTime) / 1000));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linked.get(i).translate(-50, 50);
        }
        endTime = System.nanoTime();
        System.out.println("Time for translate 10,000 linked list = " + ((endTime - startTime) / 1000));

        startTime = System.nanoTime();
        linked.iterator().next().translate(-50, 50);
        endTime = System.nanoTime();
        System.out.println("Time iterator translate 10,000 linked list = " + ((endTime - startTime) / 1000));

        startTime = System.nanoTime();
        for (Point point: linked) {
            point.translate(-50, 50);
        }
        endTime = System.nanoTime();
        System.out.println("Time foreach boucle translate 10,000 linked list = " + ((endTime - startTime) / 1000));

        startTime = System.nanoTime();

        endTime = System.nanoTime();
        System.out.println("Time foreach boucle translate 10,000 linked list = " + ((endTime - startTime) / 1000));

        long start = System.nanoTime();
        int middle = linked.size() / 2;
        for (int i = 0; i < 100000; i++) {
            linked.get(middle).translate(-50, 50);
        }
        long stop = System.nanoTime();
        System.out.println("Elapsed time : " + (stop - start) / 1000);


        // 10,000 Array creation
        startTime = System.nanoTime();
        var array = createRandomArrayList(10000, 100);
        endTime = System.nanoTime();
        System.out.println("Time for create 10,000 array list = " + ((endTime - startTime) / 1000));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            array.get(i).translate(-50, 50);
        }
        endTime = System.nanoTime();
        System.out.println("Time for translate 10,000 array list = " + ((endTime - startTime) / 1000));

        startTime = System.nanoTime();
        array.iterator().next().translate(-50, 50);
        endTime = System.nanoTime();
        System.out.println("Time iterator translate 10,000 linked list = " + ((endTime - startTime) / 1000));

        startTime = System.nanoTime();
        for (Point point: array) {
            point.translate(-50, 50);
        }
        endTime = System.nanoTime();
        System.out.println("Time foreach boucle translate 10,000 linked list = " + ((endTime - startTime) / 1000));

        start = System.nanoTime();
        middle = array.size() / 2;
        for (int i = 0; i < 100000; i++) {
            array.get(middle).translate(-50, 50);
        }
        stop = System.nanoTime();
        System.out.println("Elapsed time : " + (stop - start) / 1000);
    }

    public static List<Point> createRandomLinkedList(int n, int range) {
        Random random = new Random();
        LinkedList<Point> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(new Point(random.nextInt(range), random.nextInt(range)));
        }

        return linkedList;
    }

    public static List<Point> createRandomArrayList(int n, int range) {
        Random random = new Random();
        LinkedList<Point> arrayList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new Point(random.nextInt(range), random.nextInt(range)));
        }

        return arrayList;
    }

    public static int removeInsideDisk(List<Point> l, Point c, int r) {
        int index = l.indexOf(c);
        int i;
        for (i = index - r; i < index + r; i++) {
            l.remove(i);
        }

        return i;
    }
}
