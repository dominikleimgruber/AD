package ch.hslu.ad.sw04.Aufgabe2;

import ch.hslu.ad.sw02.part3.MyStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * Comparison between different Stack implementations to figure out which one is the fastest.
 */
public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    private static String[] generateArray(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = "A";
        }
        return array;
    }

    public static void main(String[] args) {

        long startDatacreation = System.currentTimeMillis();
        String[] array = generateArray(100000000);
        long endDatacreation = System.currentTimeMillis();
        LOG.info("Data creation: " + (endDatacreation - startDatacreation));


        MyStack<String> myStack = new MyStack<>(100000000);
        long startMyStack = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            myStack.push(array[i]);
        }
        long endMyStack = System.currentTimeMillis();
        LOG.info("My Stack: " + (endMyStack - startMyStack));

        Stack<String> javaStack = new Stack<>();
        long startStack = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            javaStack.push(array[i]);
        }
        long endStack = System.currentTimeMillis();
        LOG.info("Java Stack: " + (endStack - startStack));

        Deque<String> deque = new ArrayDeque<>(100000000);
        long startDeque = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            deque.push(array[i]);
        }
        long endDeque = System.currentTimeMillis();
        LOG.info("Java Deque: " + (endDeque - startDeque));

    }

}
