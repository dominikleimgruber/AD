package ch.hslu.ad.sw14.part1_2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchMachine {

    private static final Logger LOG = LogManager.getLogger(SearchMachine.class);

    public static int stateSearch(final String s) {
        int i = 0;
        int notFount = -1;
        String state = " ";
        do {
            char a = s.charAt(i);
            switch (state) {
                case " ":
                    if (a == 'A') {
                        state = "A";
                    }
                    break;
                case "A":
                    if (a == 'N') {
                        state = "AN";
                    } else if (a != 'A') {
                        state = " ";
                    }
                    break;
                case "AN":
                    if (a == 'A') {
                        state = "ANA";
                    } else {
                        state = " ";
                    }
                    break;
                case "ANA":
                    if (a == 'N') {
                        state = "ANAN";
                    } else if (a == 'A') {
                        state = "A";
                    } else {
                        state = " ";
                    }
                    break;
                case "ANAN":
                    if (a == 'A') {
                        state = "ANANA";
                    } else {
                        state = " ";
                    }
                    break;
                case "ANANA":
                    if (a == 'S') {
                        state = "ANANAS";
                    } else if (a == 'N') {
                        state = "ANAN";
                    } else if (a == 'A') {
                        state = "A";
                    } else {
                        state = " ";
                    }
                    break;
            }
            i++;
        } while (!(state.equals("ANANAS")) && i < s.length());

        if (state.equals("ANANAS")) {
            return (i - state.length());
        }
        return notFount;
    }

    public static int kmpSearch(final String s, final String pattern) {
        final int n = s.length();
        final int m = pattern.length();
        int j = 0;
        int i = 0;

        int[] next = initNext(pattern);


        do {
            if ((j == -1) || (s.charAt(i) == pattern.charAt(j))) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        } while ((j < m) && (i < n));
        if (j == m) {
            return (i - m);
        } else {
            return -1;
        }
    }


    private static int[] initNext(final String pattern) {
        final int m = pattern.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = j;

        do {
            if ((j == -1) || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }
}
