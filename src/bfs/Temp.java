//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.*;
//
//public class Main {
//    static int N, M;
//    static List<List<Integer>> l = new ArrayList<>();
//    static int[] visited;
//    //    static int[][] nodes = {{}, {2, 3}, {1, 8}, {1, 4, 5}, {3, 5}, {3, 4}, {7, 8}, {6, 8}, {6, 7}};
//    static int[][] nodes = {{}, {2, 4}, {1, 3, 4}, {2, 4}, {1, 2, 3}, {}};
//    static boolean[] checked;
//    static Queue<Integer> queue = new LinkedList<>();
//    static LinkedList<Integer> order = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("test/testInput"));
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int k = scanner.nextInt();
//        checked = new boolean[n + 1];
////        System.out.println(Arrays.toString(checked));
//        for (int i = 0; i <= n; i++)
//            l.add(new ArrayList<>());
//        for (int i = 0; i < m; i++) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//
//            l.get(a).add(b);
//            l.get(b).add(a);
////            System.out.println(l);
//        }
//        for (int i = 0; i < l.size(); i++)
//            Collections.sort(l.get(i));
////        System.out.println(l);
//
//        LinkedList<Integer> order = bfs(k);
//
////        System.out.println(order);
////        System.out.println(Arrays.toString(checked));
//        for (int i = 0; i < checked.length; i++) {
//            if (i == 0) continue;
//            if (checked[i]) {
//
//                System.out.println(order.poll());
//            } else System.out.println("0");
//        }
//    }
//
//    private static LinkedList<Integer> bfs(int start) {
//        queue.offer(start);
//        checked[start] = true;
//        while (!queue.isEmpty()) {
//            int nodeIndex = queue.poll();
//            order.offer(nodeIndex);
//            for (int i = 0; i < l.get(nodeIndex).size(); i++) {
//                int index = l.get(nodeIndex).get(i);
//                if (!checked[index]) {
//                    checked[index] = true;
//                    queue.offer(index);
//                }
//            }
//        }
//        return order;
//    }
//
//}
