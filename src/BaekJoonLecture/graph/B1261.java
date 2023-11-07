package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

//알고스팟
public class B1261 {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        scanner.nextLine();


        int[][] map = new int[n][m];
        int[][] c = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(0);
        q.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = -1;
            }
        }
        c[0][0] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (c[nx][ny] == -1) {
                        if (map[nx][ny] == 0) {
                            q.addFirst(ny);
                            q.addFirst(nx);
                            c[nx][ny] = c[x][y];
                        } else {
                            q.addLast(nx);
                            q.addLast(ny);
                            c[nx][ny] = c[x][y] + 1;
                        }
                    }
                }

            }
        }
        System.out.println(c[n - 1][m - 1]);
    }

}
