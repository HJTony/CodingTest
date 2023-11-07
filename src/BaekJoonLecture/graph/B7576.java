package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//토마토 - 순차적으로 익는 토마토 계산하기
public class B7576 {
    static int n;
    static int m;
    static int[][] a;
    static int[][] dist;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        a = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
                dist[i][j] = -1;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    q.add(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && a[nx][ny] == 0 && dist[nx][ny] == -1) {
                    q.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0)
                    count++;
            }
        }
        if (count == 0) {
            System.out.println(0);
            System.exit(0);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans < dist[i][j]) ans = dist[i][j];
            }
        }
        System.out.println(ans);

    }

}
