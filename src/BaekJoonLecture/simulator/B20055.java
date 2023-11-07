package BaekJoonLecture.simulator;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//컨베이어벨트 로봇
public class B20055 {
    static LinkedList<Integer> belt = new LinkedList<>();
    static LinkedList<Boolean> on = new LinkedList<>();
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        k = scanner.nextInt();
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        int ans = 0;
        String[] nums = br.readLine().split(" ");
        for(int i=0;i<2*n;i++) {
//            belt.add(scanner.nextInt());
            belt.add(Integer.parseInt(nums[i]));
        }

        for(int i=0;i<n;i++) {
            on.add(false);
        }

        do {
            rotate();
            moveRobotIfEnable();
            setRobotInFirstIndex();
            ans++;
        }while(!downState());

        System.out.println(ans);

    }

    public static void rotate() {
        belt.addFirst(belt.getLast());
        belt.removeLast();

        for(int i=n-1;i>=0;i--) {
            if(on.get(i)) {
                on.set(i,false);
                if(i==n-1) continue;
                on.set(i+1,true);
            }
        }
        if(on.get(n-1)) on.set(n-1, false);
    }

    private static void moveRobotIfEnable() {
        for(int i=n-2;i>=0;i--) {
            if(on.get(i)) {
                if(!on.get(i+1) && belt.get(i+1) > 0) {
                    on.set(i,false);
                    on.set(i+1,true);
                    belt.set(i+1, belt.get(i+1) - 1);
                }
            }
        }
    }

    private static void setRobotInFirstIndex() {
        int firstIndex = belt.get(0);
        if(firstIndex > 0) {
            on.set(0, true);
            belt.set(0, firstIndex - 1);
        }
    }

    private static boolean downState() {
        int count = k;
        for(int a : belt) {
            if (a==0) count--;
        }
        return count<=0;
    }

}
