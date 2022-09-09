package com.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        // Standard for loop.
        for (int i = 1; i < 10 ; i++) {
            System.out.println(i);
        }

        // Autoboxing.
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1, 1); // auto boxing
        map.put(2, 2); // auto boxing

        // Alt for loop.
        for (int i : map.keySet()) {
            System.out.println(i);
        }

        // A lambda expression is a short block of code which takes in parameters and returns a value.
        // Lambda expressions are similar to methods, but they do not need a name, and they can be implemented
        // right in the body of a method. Introduced in Java 8.

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.forEach(System.out::println);

        numbers.forEach( (n) -> { System.out.println(n); } );

        // Can store lambda in a variable.
        Consumer<Integer> method = (n) -> { System.out.println(n); };
        numbers.forEach( method );

        // Using Anonymous Inner class that define inside argument
        // Here constructor argument
        Thread t = new Thread(new Runnable() {
            public void run()
            {
                System.out.println("Child Thread");
            }
        });

        t.start();

        System.out.println("Lambda Thread Start");

        //
        new Thread(() -> { // Lambda Expression
            for (int i = 1; i <= 5; i++) {
                System.out.println("Lambda Thread: " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("Lambda Thread End");
    }
}
