package bfs;

import java.io.*;
import java.util.*;

public class Algo4 {
    static int N, M;
    static List<List<Integer>> l = new ArrayList<>();
    static int[] visited;

    public void algo4Start() throws IOException{
        int R = Init();

        bfs(R);

        printResult();
    }

    private static void printResult() {
        for(int i = 1; i<=N; i++)
            System.out.println(visited[i]);
    }

    private static int Init() throws IOException {
        System.setIn(new FileInputStream("test/testInput2"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        for(int i = 0; i<=N; i++)
            l.add(new ArrayList<>());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            l.get(A).add(B);
            l.get(B).add(A);
        }

        for(int i = 1; i<=N; i++)
            Collections.sort(l.get(i));
        return R;
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(start);
        visited[start] = cnt++;

        while(!q.isEmpty()){
            int a = q.poll();

            for(int i = 0; i<l.get(a).size(); i++){
                int nextV = l.get(a).get(i);

                if(visited[nextV] != 0)
                    continue;

                q.offer(nextV);
                visited[nextV] = cnt++;
            }
        }
    }
}