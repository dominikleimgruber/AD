package ch.hslu.ad.sw14.part4;

import ch.hslu.ad.sw14.part1_2.SearchMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        String s = readFile("/Users/dominikleimgruber/Documents/work/Hochschule/" +
                "FS20/AD/ad_exercises/src/main/java/ch/hslu/ad/sw14/part4/test.txt");

        long start = System.currentTimeMillis();
        LOG.info("Startindex:  {}", Quicksearch.quickSearch(s, "24101997"));
        long end = System.currentTimeMillis();
        LOG.info("Time to search Quicksearch: {}", end - start);

        start = System.currentTimeMillis();
        LOG.info("Startindex: {}", Quicksearch.optimalMismatch(s, "24101997"));
        end = System.currentTimeMillis();
        LOG.info("Time optimal mismatch: {}", end - start);

        start = System.currentTimeMillis();
        LOG.info("Startindex: {}", SearchMachine.kmpSearch(s, "24101997"));
        end = System.currentTimeMillis();
        LOG.info("Time kmp search: {}", end - start);

    }


    private static String readFile(String path) {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(
                             new FileInputStream(path), StandardCharsets.US_ASCII))) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            LOG.error(e);
        }

        return sb.toString();

    }
}
