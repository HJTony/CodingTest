package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Algo3 {
//    static int[][] nodes = {{}, {2, 3}, {1, 8}, {1, 4, 5}, {3, 5}, {3, 4}, {7, 8}, {6, 8}, {6, 7}};
    static int[][] nodes = {{},{2,5},{1,3,5},{2,5},{},{1,2,3}};
    static boolean[] checked = new boolean[nodes.length];
    static Queue<Integer> queue = new LinkedList<>();
    static LinkedList<Integer> order = new LinkedList<>();
    public void algo3Start() {
        LinkedList<Integer> order = bfs(1);
//        System.out.println(order);
//        System.out.println(Arrays.toString(checked));
        for(int i=0;i<checked.length;i++) {
            if(i==0)continue;
            if(checked[i]){
                System.out.println(order.poll());
            }
            else
                System.out.println("0");
        }
    }

    private static LinkedList<Integer> bfs(int start) {
        queue.offer(start);
        checked[start] = true;
        while (!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            order.offer(nodeIndex);
            for (int i = 0; i < nodes[nodeIndex].length; i++) {
                int index = nodes[nodeIndex][i];
                if (!checked[index]) {
                    checked[index] = true;
                    queue.offer(index);
                }
            }
        }
        return order;
    }
}
