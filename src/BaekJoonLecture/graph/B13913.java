package BaekJoonLecture.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//숨바꼭질4
public class B13913 {
    static int MAX = 1000000;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] count = new int[MAX];
        int[] from = new int[MAX];
        Arrays.fill(count, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        count[n] = 0;

        while (!q.isEmpty()) {
            int next = q.remove();
//            if(next == k) break;
            if (0 <= (next - 1) && (next - 1) < MAX && count[next - 1] == -1) {
                q.add(next - 1);
                from[next - 1] = next;
                count[next - 1] = count[next] + 1;
            }
            if (0 <= (next * 2) && (next * 2) < MAX && count[next * 2] == -1) {
                q.add(next * 2);
                from[next * 2] = next;
                count[next * 2] = count[next] + 1;
            }
            if (0 <= (next + 1) && (next + 1) < MAX && count[next + 1] == -1) {
                q.add(next + 1);
                from[next + 1] = next;
                count[next + 1] = count[next] + 1;
            }
        }
        System.out.println(count[k]);
        Stack<Integer> stack = new Stack<>();
        stack.add(k);
        for (int i = k; i != n; ) {
            stack.add(from[i]);
            i = from[i];
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
