package BaekJoonLecture2.bruteforce.recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class B1182 {
    static int n;
    static int s;
    static int[] a;
    static int ans = 0;
    static boolean[] temp;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        a = new int[n];
        temp = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        go(0, 0);
        System.out.println(ans);
    }

    public static void go(int index, int selected) {
        if (index == n) {
            check();
//            System.out.println(Arrays.toString(temp));
            return;
        }
        temp[index] = true;
        go(index + 1, selected + 1);
        temp[index] = false;
        go(index + 1, selected);
    }

    public static void check() {
        int total = 0;
        int falseCount = 0;
        for(int i=0;i<n;i++) {
            if(!temp[i]) falseCount ++;
        }
        if(falseCount == n) return;
        for(int i=0;i<n;i++) {
            if(temp[i]) total += a[i];
        }
        if(total == s) ans ++;
    }
}
