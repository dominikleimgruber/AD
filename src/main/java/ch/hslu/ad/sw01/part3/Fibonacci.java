package ch.hslu.ad.sw01.part3;

public class Fibonacci {

    private long[] numbers;

    public long fiboRec1(final int n) {
        /*
        Die Rekursionbasis wird auf den Wert 1 gesetzt, da bei lediglich dem Wert 0 ein StackOverflow entstehen würde.
        Da jedoch n = 0 ebenfalls eine Möglichkeit darstellt musste noch eine weitere Bedingung hinzugefügt werden.
         */

        if (n == 0) {
            return 0;
        } else if (n == 1) { // Rekursionsbasis
            return 1;
        } else {
            return fiboRec1(n - 1) + fiboRec1(n - 2);
        }
    }


    public long fiboRec2(final int n) {
        if (numbers == null) {
            numbers = new long[n + 1];
            numbers[0] = 0;
        }

        if (n == 0) {
            numbers[0] = 0;
        } else if (n == 1) {
            numbers[1] = 1;
        } else {
            fiboRec2(n - 1);
            numbers[n] = numbers[n - 1 ] + numbers[n - 2];
        }
        return numbers[n];
    }
    /*
    1,1,2,3,5,8,13 ...
    previous + previousPrevious = currentPosition
    previousPrevious = previous
    previous  = currentPosition

    whats the startvalue of currentPosition?
    if n = 0 currentPosition should be 0
    if n = 1 currentPosition 1
    if n = 2 currentPosition 1

     */

    public long fiboItr(final int n) {
        long currentPosition = 0;
        long previousPosition = 0;
        long previousPreviousPosition = 1;

        for (int i = 0; i < n; i++) {

            currentPosition = previousPosition + previousPreviousPosition;
            previousPreviousPosition = previousPosition;
            previousPosition = currentPosition;

        }


        return currentPosition;
    }

}
