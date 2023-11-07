package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean compare(Pair b) {
        return this.x == b.x && this.y == b.y;
    }
}
//나이트의 이동
public class B7562 {
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static int[][] dist;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++) {
            int l = scanner.nextInt();
            dist = new int[l][l];
            for(int j=0;j<l;j++) {
                for(int k=0;k<l;k++) {
                    dist[j][k] = -1;
                }
            }
            Pair start = new Pair(scanner.nextInt(), scanner.nextInt());
            Pair end = new Pair(scanner.nextInt(), scanner.nextInt());

            System.out.println(bfs(l, start, end));


        }
    }

    private static int bfs(int l, Pair start, Pair end) {
        if(start.compare(end)) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        dist[start.x][start.y] = 0;
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            if (p.compare(end)) {
                return dist[x][y];
            }
            for(int j=0;j<8;j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(0<=nx && nx < l && 0<=ny && ny < l && dist[nx][ny] == -1) {
                    q.add(new Pair(nx,ny));
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
        return -1;
    }

}
