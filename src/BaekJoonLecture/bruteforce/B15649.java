package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B15649 {
    static boolean[] c = new boolean[9];
    static int[] a;
    public static void test() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[m];

        getCom(0, n, m);

    }

    private static void getCom(int index, int n, int m) {
        if(index == m) {
            for(int i : a) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++) {
            if(c[i]) continue;
            c[i] = true; a[index] = i;
            getCom(index + 1, n, m);
            c[i]=false;
        }
    }
}