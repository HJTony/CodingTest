package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class B18290Fail {
    static int ans = Integer.MIN_VALUE;
    private static int[][] map;
    private static boolean[][] ok;
    private static int n;
    private static int m;
    private static int k;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void test(String[] args) throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        map = new int[m][n];
        ok = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        go(0, 0, 0, 0);
        System.out.println(ans);
    }

    private static void go(int index, int x, int y, int count) {
        if (index == k) {
            if (ans < count) ans = count;
            return;
        }
        for (int i = y; i < m; i++) {
            for (int j = x; j < n; j++) {
                if (ok[i][j]) continue;
                boolean c = true;
                for (int p = 0; p < 4; p++) {
                    int ddx = j + dx[p];
                    int ddy = i + dy[p];
                    if (0 <= ddx && ddx <= n && 0 <= ddy && ddy <= m) {
                        if (ok[ddy][ddx]) {
                            c = false;
                            break;
                        }
                    }
                }
                if (c) {
                    ok[i][j] = true;
                    go(index + 1, x, y, count + map[i][j]);
                    ok[i][j] = false;
                }
            }
        }
    }
}
