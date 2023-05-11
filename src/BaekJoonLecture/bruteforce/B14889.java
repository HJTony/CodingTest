package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class B14889 {
    static int n;
    static int[][] map;
    static ArrayList<Integer> first = new ArrayList<>();
    static ArrayList<Integer> second = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        go(0, first, second);
        System.out.println(ans);
    }

    private static void go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        if (index == n) {
            if (first.size() == n / 2 && second.size() == n / 2) {
                int t1 = 0;
                int t2 = 0;
                for(int i=0;i<n/2;i++) {
                    for(int j= 0;j<n/2;j++) {
                        if(i==j) continue;
                        t1 += map[first.get(i)][first.get(j)];
                        t2 += map[second.get(i)][second.get(j)];
                    }
                }
                int v = Math.abs(t1-t2);
                if(ans > v) ans = v;
            }
            return;
        }
        if (first.size() > n / 2) return;
        if (second.size() > n / 2) return;

        first.add(index);
        go(index + 1, first, second);
        first.remove(first.size() - 1);

        second.add(index);
        go(index + 1, first, second);
        second.remove(second.size() - 1);
    }
}
