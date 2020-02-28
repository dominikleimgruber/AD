package ch.hslu.ad.sw02.part3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(3);
        stack.push("toll");
        stack.push("sind");
        stack.push("Datenstrukturen");

        for(int i = 0; i < stack.getSize(); i++){
            LOG.info(stack.pop());
        }

    }
}
