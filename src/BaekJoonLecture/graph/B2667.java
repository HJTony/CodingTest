package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//단지번호 붙이기
public class B2667 {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    static int[][] a;
    static int[][] group;
    static int n;


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        a = new int[n][n];
        group = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] == 0 && a[i][j] == 1) {
                    count++;
                    bfs(i, j, count);

                }
            }
        }

        int[] ans = new int[count];
        for(int i=0;i<n;i++ ){
            for(int j= 0;j<n;j++) {
                if(group[i][j]!=0) {
                    ans[group[i][j]-1] +=1;
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(count);
        for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
    }

    public static void bfs(int i, int j, int count) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        group[i][j] = count;

        while(!q.isEmpty()) {
            Pair p = q.remove();
            i = p.x;
            j = p.y;

            for(int k=0;k<4;k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if(0<=nx && nx<n && 0<=ny && ny <n) {
                    if(a[nx][ny] == 1 && group[nx][ny] == 0) {
                        group[nx][ny] = count;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    public static void dfs(int x, int y, int cnt) {
        group[x][y] = cnt;
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(nx, ny, cnt);
                }
            }
        }
    }
}
