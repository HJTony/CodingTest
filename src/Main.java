
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] map;
    static int[] list;
    static int ans = Integer.MAX_VALUE;
    static int[] temp = new int[2];
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        list = new int[n * (n - 1) / 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) continue;
                list[index++] = map[i][j] + map[j][i];
            }
        }
        go(0,0);
        System.out.println(ans);
    }

    private static void go(int index, int start) {
        if (index == 2) {
            int t = Math.abs(temp[1] - temp[0]);
            if(ans > t) ans = t;
            return;
        }

        for (int i = start; i < list.length; i++) {
            temp[index] = list[i];
            go(index+1,i+1);
        }
    }
}
