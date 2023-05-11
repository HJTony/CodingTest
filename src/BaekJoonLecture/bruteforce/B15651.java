package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B15651 {
    static int[] a;
    public static void test() throws FileNotFoundException {
        //StringBuilder와 BufferedReader 사용할것!
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[m];
        go(0, n, m);
    }
    private static void go(int index, int n, int m) {
        if(index == m) {
            for(int i : a) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++) {
            a[index] = i;
            go(index+1, n, m);
        }
    }
}
