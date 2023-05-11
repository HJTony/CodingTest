package BaekJoonLecture.GCDorLCM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GCDCal {
    public static void test() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();


        System.out.println(gcdCal(a, b));
    }

    public static int gcdCal(int a, int b) {
        int g = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                g = i;
            }
        }
        return g;
    }

    public static int euclidLoop(int max, int min) {
        int a = Math.max(max, min);
        int b = Math.min(max, min);
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int euclidRecur(int max, int min) {
        int a = Math.max(max, min);
        int b = Math.min(max, min);

        if (b == 0) {
            return a;
        } else return euclidRecur(b, a % b);
    }
}
