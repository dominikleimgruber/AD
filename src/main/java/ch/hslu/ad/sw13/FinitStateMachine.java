package ch.hslu.ad.sw13;

public class FinitStateMachine {


    public static boolean isWordLanguage(final String word) {
        String state = "z0";
        for (char a : word.toCharArray()) {
            switch (a) {
                case '0':
                    switch (state) {
                        case "z0":
                            state = "z1";
                            break;
                        case "z2":
                            state = "z4";
                            break;
                        default:
                            return false;
                    }
                    break;
                case '1':
                    switch (state) {
                        case "z1":
                        case "z3":
                        case "z4":
                            state = "z2";
                            break;
                        case "z2":
                            state = "z3";
                            break;
                        default:
                            return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return "z1".equals(state) || "z4".equals(state);
    }
}
