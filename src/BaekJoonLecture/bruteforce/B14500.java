package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class B14500 {
    static int[][] map;
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

    public static void test() throws FileNotFoundException {
//        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        map = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int max = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<19;k++) {
                    boolean ok = true;
                    int start = map[i][j];
                    for(int l=0;l<3;l++) {
                        int y =board[k][l][0];
                        int x = board[k][l][1];

                        if(0<=(y+i) && (y+i) <n && 0<=(x+j) && (x+j)<m) {
                            start += map[y+i][x+j];
                        }else {
                            ok = false;
                            break;
                        }
                    }
                    if(ok)
                        max = Math.max(max, start);
                }
            }
        }
        System.out.println(max);
    }

}
