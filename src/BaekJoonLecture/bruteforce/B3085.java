package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class B3085 {

    static char[][] board;
    static int n;

    public static void test() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        n= N;
        scanner.nextLine();
        board = new char[N][N];
        Point a = new Point(0, 0);

//        scanner.next().toCharArray();
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        int maxCount = 0;

        //가로로 2개씩 잡음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
//                System.out.println(board[i][j]+""+board[i][j+1]);
                if (board[i][j] == board[i][j + 1]) continue;
                maxCount = Math.max(maxCount, checkPointBox(new Point(i,j), new Point(i,j+1)));
            }
        }
//        //세로로 2개씩 잡음
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.println(board[i][j]+""+board[i+1][j]);
                if (board[i][j] == board[i + 1][j]) continue;
                maxCount = Math.max(maxCount, checkPointBox(new Point(i,j), new Point(i+1,j)));
            }
        }
        System.out.println(maxCount);
    }

    private static int checkPointBox(Point a, Point b) {
        HashMap<Character, Integer> map  = new HashMap<>();
        map.put('C',0);        map.put('P', 0);        map.put('Z', 0);        map.put('Y', 0);
        changeBox(a, b);
        int max = 0;
        for(int i=0;i<n;i++) {
            char index = board[i][0];
            for(int j=0;j<n;j++) {
                if(index == board[i][j]) {
                    map.put(index, map.get(index) + 1);
                    max = Math.max(max, Collections.max(map.values()));
                }else {
                    index = board[i][j];
                    map.put(index, 1);
                }
            }
//            max = Math.max(max, Collections.max(map.values()));
            map.put('C',0);        map.put('P', 0);        map.put('Z', 0);        map.put('Y', 0);
        }

        for(int j=0;j<n;j++) {
            char index = board[0][j];
            for(int i=0;i<n;i++) {
                if(index == board[i][j]) {
                    map.put(index, map.get(index) + 1);
                    max = Math.max(max, Collections.max(map.values()));
                }else {
                    index = board[i][j];
                    map.put(index,1);
                }
            }
            map.put('C',0);        map.put('P', 0);        map.put('Z', 0);        map.put('Y', 0);
        }

        recoverBox(a, b);
        return max;
    }

    private static void recoverBox(Point a, Point b) {
        char temp = board[a.getI()][a.getJ()];
        board[a.getI()][a.getJ()] = board[b.getI()][b.getJ()];
        board[b.getI()][b.getJ()] = temp;
    }

    private static void changeBox(Point a, Point b) {
        char temp = board[a.getI()][a.getJ()];
        board[a.getI()][a.getJ()] = board[b.getI()][b.getJ()];
        board[b.getI()][b.getJ()] = temp;
    }

    private static void printBox() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

class Point {
    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    private int i;
    private int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}