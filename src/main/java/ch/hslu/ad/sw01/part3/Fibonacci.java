package ch.hslu.ad.sw01.part3;

public class Fibonacci {

    private int[] fiboNumbers;

    public int fiboRec1(final int n) {
        /*
        Die Rekursion Basis wird auf den Wert 1 gesetzt, da bei lediglich dem Wert 0 ein StackOverflow entstehen würde.
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
    
}
