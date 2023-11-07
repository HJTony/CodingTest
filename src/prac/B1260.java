package prac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class B1260 {
    static ArrayList<Integer>[] eList;
    static int n;
    static int m;
    static int v;
    static boolean[] c;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        v = scanner.nextInt();
        scanner.nextLine();
        eList = new ArrayList[n + 1];
        c = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            eList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            eList[from].add(to);
            eList[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            eList[i].sort(Comparator.naturalOrder());
        }
        dfs(v);
        System.out.println();
        bfs();

    }

    static void bfs() {
        boolean[] checked = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        checked[v] = true;
        while (!queue.isEmpty()) {
            int item = queue.remove();
            System.out.print(item + " ");
            for (int i = 0; i < eList[item].size(); i++) {

                if (!checked[eList[item].get(i)]) {
                    queue.add(eList[item].get(i));
                    checked[eList[item].get(i)] = true;
                }
            }
        }
    }

    static void dfs(int start) {
        if (c[start]) return;
        c[start] = true;
        System.out.print(start + " ");
        for (int node : eList[start]) {
            if (!c[node]) {
                dfs(node);
            }
        }
    }
}
