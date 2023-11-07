package BaekJoonLecture.simulator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//배열돌리기3

public class B16935 {
    static int n;
    static int m;
    static int r;
    static int[][] a;
    static int[][] b;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        r = scanner.nextInt();
        a = new int[n][m];
        if(n<m)
            b = new int[m][m];
        else
            b = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            int cal = scanner.nextInt();
            switch (cal) {
                case 1:
                    cal_1();
                    break;
                case 2:
                    cal_2();
                    break;
                case 3:
                    cal_3();
                    break;
                case 4:
                    cal_4();
                    break;
                case 5:
                    cal_5();
                    break;
                case 6:
                    cal_6();
                    break;
            }
        }


    }

    //        3번 연산은 오른쪽으로 90도 회전시키는 연산이다.
//        4번 연산은 왼쪽으로 90도 회전시키는 연산이다.
//        5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.
//        5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.
//        6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.
    static void cal_1() {
        for (int i = 0; i < n; i++) {
            b[n - i - 1] = a[i];
        }
    }

    static void cal_2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][m - j - 1] = a[i][j];
            }
        }
    }

    static void cal_3() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                b[j][n-i-1] = a[i][j];
            }
        }
    }

    static void cal_4() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                b[m-j-1][i] = a[i][j];
            }
        }
    }

    static void cal_5() {
    }

    static void cal_6() {
    }

    static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    static int[][] operation5(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];;
        for (int i=0; i<n/2; i++) {
            for (int j=0; j<m/2; j++) {
                ans[i][j+m/2] = a[i][j];
                ans[i+n/2][j+m/2] = a[i][j+m/2];
                ans[i+n/2][j] = a[i+n/2][j+m/2];
                ans[i][j] = a[i+n/2][j];
            }
        }
        return ans;
    }

    static int[][] operation6(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];;
        for (int i=0; i<n/2; i++) {
            for (int j=0; j<m/2; j++) {
                ans[i+n/2][j] = a[i][j];
                ans[i][j] = a[i][j+m/2];
                ans[i][j+m/2] = a[i+n/2][j+m/2];
                ans[i+n/2][j+m/2] = a[i+n/2][j];
            }
        }
        return ans;
    }
}

