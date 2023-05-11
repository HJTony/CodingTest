package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B18290 {

    private static int n, m, k;
    private static int[][] map = new int[10][10];
    private static boolean[][] c = new boolean[10][10];
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int ans = Integer.MIN_VALUE;

    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        go(0,0,0,0);
        System.out.println(ans);
    }
    private static void go(int x, int y, int index, int count) {
        if(index == k) {
            if(ans < count) ans = count;
            return;
        }
        for(int i=y;i<m;i++) {
            for(int j=x;j<n;j++) {
                if(c[i][j]) continue;
                boolean ok = true;
                for(int p = 0;p<4;p++) {
                    int ddx = j + dx[p];
                    int ddy = i + dy[p];
                    if(0<=ddx && ddx < n && 0<=ddy && ddy < m) {
                        if(c[ddy][ddx]) ok = false;
                    }
                }
                if(ok) {
                    c[i][j] = true;
                    go(x,y,index +1, count + map[i][j]);
                    c[i][j] = false;
                }
            }
        }
    }
}
