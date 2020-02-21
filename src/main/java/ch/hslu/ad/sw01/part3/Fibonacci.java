package ch.hslu.ad.sw01.part3;

public class Fibonacci {

    private int[] fiboNumbers;

    public int fiboRec1(final int n) {
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

 
    public int fiboItr( int n) {
        int currentPosition = 0;
        int previousPosition = 0;
        int previousPreviousPosition = 0;

        for(int i = 0; i < n; i++){

            currentPosition = previousPosition + previousPreviousPosition;
            previousPreviousPosition = previousPosition;
            if (currentPosition != 0){
                previousPosition = currentPosition;
            }else{
                previousPosition = 1;
            }


        }


        return currentPosition;
    }

}
