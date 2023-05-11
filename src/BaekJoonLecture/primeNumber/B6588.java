package BaekJoonLecture.primeNumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B6588 {
    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX+1];
    public static void test() throws FileNotFoundException {
//        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);

        int n = -1;
        for (int i = 2; i < MAX; i++)
            isPrime[i] = true;
        eratosCal(MAX);
        while (true) {
            n = scanner.nextInt();
            if(n==0) break;

            int[] result = getNum(n);
            int a = result[0];
            int b = result[1];
            if(isPrime[b])
                System.out.println(n + " = " + b + " + " + a);
            else
                System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    private static int[] getNum(int n) {
        int[] result = new int[2];

        for(int i=2;i<=n;i++) {
            if(isPrime[n-i]) {
                result[0] = n-i;
                result[1] = i;
                break;
            }
        }

        return result;
    }
    private static void eratosCal(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
