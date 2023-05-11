package BaekJoonLecture.bruteforce.permutation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class B10971 {
    static int n;
    static int[][] map;
    static int[] a;
    static int ans = Integer.MAX_VALUE;
    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        a = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        for(int i=0;i<n;i++) {
            a[i] = i;
        }
        do{
            boolean ok = true;
            int sum = 0;
            for(int i=0;i<n-1;i++) {
                if(map[a[i]][a[i+1]] == 0) ok = false;
                else sum+= map[a[i]][a[i+1]];
            }
            if(ok && map[a[n-1]][a[0]] != 0) {
                sum+= map[a[n-1]][a[0]];
                if(ans > sum) ans = sum;
            }
        }while(next_permutation(a));
        System.out.println(ans);
    }

    private static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }
        if (i == 0) return false;

        int j = a.length - 1;
        while (a[i - 1] >= a[j]) {
            j -= 1;
        }
        int t = a[j];
        a[j] = a[i - 1];
        a[i - 1] = t;

        for (int index = i, last = a.length - 1; index < last; index++, last--) {
            int temp = a[index];
            a[index] = a[last];
            a[last] = temp;
        }

        return true;
    }

}
