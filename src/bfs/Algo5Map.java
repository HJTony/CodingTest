package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Algo5Map {
    private int N;
    private int[][] map;
    private HashMap<Integer, Integer> map2;


    public void algo5Start() throws FileNotFoundException {

        init();

        mapInit();
        System.out.println(map2.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(",")));
    }

    private void mapInit() {
        int[] mi = {0, 0, -1, 1};
        int[] mj = {1, -1, 0, 0};
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int d = 0; d < 4; d++) {
                    int ni = map[y][x] + mi[d];
                    int nj = map[y][x] + mj[d];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;

                    map2.put(map[y][x], map[ni][nj]);
                }
            }
        }
    }

    private void init() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput2"));
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        N = Integer.parseInt(str);

        map = new int[N][N];
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        System.out.println(Arrays.deepToString(map));
        map2 = new HashMap<>();
    }
}
