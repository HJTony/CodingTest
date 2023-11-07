package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class B1707 {
    static int[] c;
    static ArrayList<Integer>[] a;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            c = new int[n + 1];
            a = new ArrayList[n + 1];

            for (int j = 1; j <= n; j++)
                a[j] = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                a[from].add(to);
                a[to].add(from);
            }
            boolean ans = true;
            for(int j=1;j<=n;j++) {
                if(c[j]==0) {
                    if(!dfs(j, COLOR_RED)) ans = false;
                }
            }
            if(ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static final int COLOR_NOT_VISITED = 0;
    private static final int COLOR_RED = 1;
    private static final int COLOR_BLUE = 2;
    public static boolean dfs(int x, int color) {
        c[x] = color;
        for (int n : a[x]) {
            if (c[n] == COLOR_NOT_VISITED) {
                if(!dfs(n, 3 - color)) return false;
            }else if(c[x] == c[n]){
                return false;
            }
        }
        return true;
    }
}
