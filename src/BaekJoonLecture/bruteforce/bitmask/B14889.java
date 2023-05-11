package BaekJoonLecture.bruteforce.bitmask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class B14889 {
    static int n;
    static int[][] a;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<(1<<n);i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if((i & (1<<j)) == 0) count ++;
            }
            if(count != n/2) continue;
            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>();

            for(int k=0;k<n;k++) {
                if((i & (1<<k)) == 0) first.add(k);
                else second.add(k);
            }

            int t1 = 0;
            int t2 = 0;

            for(int k=0;k<n/2;k++) {
                for(int j=0;j<n/2;j++) {
                    if(k==j) continue;
                    t1 += a[first.get(k)][first.get(j)];
                    t2 += a[second.get(k)][second.get(j)];
                }
            }
            if(ans > Math.abs(t1-t2)) ans = Math.abs(t1-t2);
        }
        System.out.println(ans);
    }
}
