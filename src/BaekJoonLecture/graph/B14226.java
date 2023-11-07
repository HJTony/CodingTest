package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//이모티콘
public class B14226 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> q = new LinkedList<>();
        int[][] dist = new int[n+1][n+1];
        for(int i=0;i<n+1;i++) {
            Arrays.fill(dist[i], -1);
        }
        q.add(1);
        q.add(0);
        dist[1][0] = 0;

        while(!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();
            if(dist[s][s] == -1) {
                dist[s][s] = dist[s][c] + 1;
                q.add(s); q.add(s);
            }
            if(s + c <= n && dist[s+c][c] == -1) {
                dist[s+c][c] = dist[s][c] + 1;
                q.add(s+c); q.add(c);
            }
            if(s-1 >= 0 && dist[s-1][c] == -1) {
                dist[s-1][c] = dist[s][c] + 1;
                q.add(s-1); q.add(c);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(dist[n][i] != -1) {
                if(ans > dist[n][i])
                    ans = dist[n][i];
            }
        }
        System.out.println(ans);
    }

}
