package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


// 연결 요소 확인
public class B11724 {
    static boolean[] check;
    static ArrayList<Integer>[] eList;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        check = new boolean[n+1];
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

        int count = 0;
        for(int i=1;i<=n;i++) {
            if(!check[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void dfs(int x) {
        if(check[x]) return;
        check[x] = true;
        for(int node : eList[x]) {
            if(!check[node])
                dfs(node);
        }
    }
}
