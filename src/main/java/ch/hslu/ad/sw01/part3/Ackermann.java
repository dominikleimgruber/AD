package ch.hslu.ad.sw01.part3;

public class Ackermann {


    private static int counter = 0;
    public static void main(String[] args) {
        System.out.println(ack(2,2));
        System.out.println(counter);
    }

    public static long ack(final long n, final long m){

        if(n == 0){
            return m + 1;
        }else if(m == 0){
            counter++;
            return ack(n - 1, 1);

        }else if (m == 0 && n == 0){
            return 0;
        }else{
            counter += 2;
           return ack(n -1, ack(n, m -1));
        }
    }
}
