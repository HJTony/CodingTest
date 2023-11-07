package BaekJoonLecture2.bruteforce.recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Pair {
    int[] x;
    int[] y;

    public Pair(int[] x, int[] y) {
        this.x = x;
        this.y = y;
    }
}
//미완성
public class B14500 {
    static int ans = Integer.MIN_VALUE;
    static int[][] dx = {{0, 0, 0, 0}, {0, 1, 2, 3},
            {0, 0, 1, 1},
            {0, 1, 2, 2}, {0, 0, 0, -1}, {0, -1, -2, -2}, {0, 0, 0, 1},
            {0, 0, -1, -2}, {0, 0, 0, 1}, {0, 0, 1, 2}, {0, 1, 1, 1},
            {0, 1, 1, 2}, {0, 0, -1, -1}, {0, 1, 1, 2}, {0, 0, 1, 1},
            {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, 1, 2, 1}

    };
    static int[][] dy = {{0, 1, 2, 3}, {0, 0, 0, 0},
            {0, 1, 0, 1},
            {0, 0, 0, 1}, {0, 1, 2, 2}, {0, 0, 0, -1}, {0, -1, -2, -2},
            {0, 1, 1, 1}, {0, 1, 2, 2}, {1, 0, 0, 0}, {0, 0, 1, 2},
            {0, 0, 1, 1}, {0, 1, 1, 2}, {0, 0, -1, -1}, {0, 1, 1, 2},
            {0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}
    };

    static int[][][] board = {
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            //
            {{0, 1}, {1, 0}, {1, 1}},
            //
            {{1, 0}, {2, 0}, {2, 1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{-1, 0}, {-2, 0}, {-2, -1}},
            {{0, -1}, {0, -2}, {1, -2}},
            //
            {{1, 0}, {2, 0}, {2, -1}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{-1, 0}, {-2, 0}, {-2, 1}},
            {{0, -1}, {0, -2}, {-1, -2}},
            //
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {-1, 1}, {-1, 2}},
            //
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {1, 1}, {1, 2}},
            //
            {{0, 1}, {-1, 1}, {0, 2}},
            {{-1, 0}, {-1, -1}, {-2, 0}},
            {{0, -1,}, {1, -1}, {0, -2}},
            {{1, 0}, {1, 1}, {2, 0}}
    };

    static int[][] a;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int count = 19;
        Pair[] pairs = new Pair[count];
        for(int i=0;i<count;i++) {
            pairs[i] = new Pair(dx[i],dy[i]);
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                a[i][j] = scanner.nextInt();
            }
        }


        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<19;k++) {
                    int sum = 0;
                    boolean ok = true;
                    for(int l=0;l<4;l++) {
                        if(!(0<=i + pairs[k].x[l] && i + pairs[k].x[l]<n && 0<=j + pairs[k].y[l] && j+pairs[k].y[l]<m))
                            ok = false;
                    }
                    if(ok) {
                        for (int l = 0; l < 4; l++) {
                            sum += a[i+pairs[k].x[l]][j+pairs[k].y[l]];
                        }
                    }
                    if(ans < sum) ans = sum;
                }
            }
        }
        System.out.println(ans);
    }

}
