package ch.hslu.ad.sw14.part4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Quicksearch {

    private static final Logger LOG = LogManager.getLogger(Quicksearch.class);

    public static int quickSearch(final String s, final String pattern) {
        final int n = s.length();
        final int m = pattern.length();
        final int range = 256;
        final int[] shift = new int[range];

        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        for (int i = 0; i < m; i++) {
            shift[pattern.charAt(i)] = m - i;
        }

        int i = 0;
        int j = 0;
        do {
            if (s.charAt(i + j) == pattern.charAt(j)) {
                j++;
            } else {
                if ((i + m) < n) {
                    i += shift[s.charAt(i + m)];
                    j = 0;
                } else {
                    break;
                }
            }
        } while ((j < m) && ((i + m) <= n));

        if (j == m) {
            return i;
        } else {
            return -1;
        }
    }

    public static int optimalMismatch(final String s, final String pattern) {


        final int[] p = new int[pattern.length()];
        final int n = s.length();
        final int m = pattern.length();
        final int range = 256;
        final int[] shift = new int[range];


        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        for (int i = 0; i < m; i++) {
            shift[pattern.charAt(i)] = m - i;
            p[i] = i;
        }


        int i = 0;
        int j = 0;
        do {
            if (s.charAt(i + p[j]) == pattern.charAt(p[j])) {
                j++;
            } else {
                if ((i + m) < n) {
                    exchange(p, j);
                    i += shift[s.charAt(i + m)];
                    j = 0;
                } else {
                    break;
                }
            }
        } while ((j < m) && ((i + m) <= n));

        if (j == m) {
            return i;
        } else {
            return -1;
        }
    }


    private static void exchange(int[] p, int j) {
        int temp;
        if (j > 0) {
            temp = p[j];
            p[j] = p[j - 1];
            p[j - 1] = temp;
        }

    }
}
