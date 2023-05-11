package BaekJoonLecture.primeNumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimeNumberCal {
    static final int MAX = 30;
    static int[] number = new int[MAX];
    static boolean[] isPrime = new boolean[MAX];

    public static void test() throws FileNotFoundException {
//        System.setIn(new FileInputStream("test/testInput"));
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();

        for (int i = 2; i < MAX; i++)
            isPrime[i] = true;

        int[] list = eratosCal(20);

        for(int i=1;i<20;i++)
            if (isPrime[i])
                System.out.println(i + " ");
    }
    private static int[] eratosCal(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return number;
    }

    private static boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
