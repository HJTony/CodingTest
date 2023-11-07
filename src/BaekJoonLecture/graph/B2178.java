package BaekJoonLecture.graph;

//미로탐색

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
    static int n;
    static int m;
    static int[][] a;
    static boolean[][] c;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        a = new int[n][m];
        c = new boolean[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0, 1);

        System.out.println(dist[n-1][m-1]);
    }

    public static void bfs(int i, int j, int count) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        c[i][j] = true;
        dist[i][j] = count;

        while(!q.isEmpty()) {
            Pair p = q.remove();
            i = p.x;
            j = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1 && !c[nx][ny]) {
                        c[nx][ny] = true;
                        dist[nx][ny] = dist[i][j] + 1;
                        q.add(new Pair(nx,ny));
                    }
                }
            }
        }
    }

}
