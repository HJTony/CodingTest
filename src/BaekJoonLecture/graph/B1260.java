package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
//BFS and DFS 구현
public class B1260 {
    static boolean[] check;
    static ArrayList<Integer>[] eList;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();

        eList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            eList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            eList[from].add(to);
            eList[to].add(from);
        }

        for(int i=1;i<=n;i++){
            eList[i].sort(Comparator.naturalOrder());
            Collections.sort(eList[i]);
        }
        check = new boolean[n + 1];
        dfs(start);
        System.out.println();

        check = new boolean[n + 1];
        bfs(start);
        System.out.println();
    }

    public static void dfs(int x) {
        if(check[x]) return;
        check[x] = true;
        System.out.print(x + " ");
        for(int node : eList[x]) {
            if(!check[node])
                dfs(node);
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x); check[x] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for(int y : eList[node]) {
                if(!check[y]) {
                    queue.add(y);
                    check[y] = true;
                }
            }
        }
    }
}
