import java.util.Random;

public class lol {
    // implemented after https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
    public static int next(long seed) {
        int bits=32;
        long seed2 = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
        return (int)(seed2 >>> (48 - bits));
    }

    public static void main(String[] args) {
        System.out.println("Starting");
        long i1 = 1324690955L;
        long i2 = 20532528L;
        long seed =0;
        for (int i = 0; i < 65536; i++) {
            seed = i1 *65536 + i;
            if (next(seed) == i2) {
                System.out.println("Seed found: " + seed + " " + i);
               break;
            }
        }
        Random random = new Random((seed ^ 0x5DEECE66DL) & ((1L << 48) - 1));
        int o1 = random.nextInt();
        int o2 = random.nextInt();
        System.out.println("So we have that nextInt is: "+o1+" and the third one is: "+o2+" with seed: "+seed);

    }
}