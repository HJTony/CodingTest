package BaekJoonLecture.simulator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class B2290 {
    static int[][] n0 = {{-1, 1, -1}, {1, -1, 1}, {-1, 0, -1}, {1, -1, 1}, {-1, 1, -1}};
    static int[][] n1 = {{-1, 0, -1}, {0, -1, 1}, {-1, 0, -1}, {0, -1, 1}, {-1, 0, -1}};
    static int[][] n2 = {{-1, 1, -1}, {0, -1, 1}, {-1, 1, -1}, {1, -1, 0}, {-1, 1, -1}};
    static int[][] n3 = {{-1, 1, -1}, {0, -1, 1}, {-1, 1, -1}, {0, -1, 1}, {-1, 1, -1}};
    static int[][] n4 = {{-1, 0, -1}, {1, -1, 1}, {-1, 1, -1}, {0, -1, 1}, {-1, 0, -1}};
    static int[][] n5 = {{-1, 1, -1}, {1, -1, 0}, {-1, 1, -1}, {0, -1, 1}, {-1, 1, -1}};
    static int[][] n6 = {{-1, 1, -1}, {1, -1, 0}, {-1, 1, -1}, {1, -1, 1}, {-1, 1, -1}};
    static int[][] n7 = {{-1, 1, -1}, {0, -1, 1}, {-1, 0, -1}, {0, -1, 1}, {-1, 0, -1}};
    static int[][] n8 = {{-1, 1, -1}, {1, -1, 1}, {-1, 1, -1}, {1, -1, 1}, {-1, 1, -1}};
    static int[][] n9 = {{-1, 1, -1}, {1, -1, 1}, {-1, 1, -1}, {0, -1, 1}, {-1, 1, -1}};
    static int[][][] nums;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        String n = scanner.nextLine().trim();
        nums = new int[10][][];
        nums[0] = n0;
        nums[1] = n1;
        nums[2] = n2;
        nums[3] = n3;
        nums[4] = n4;
        nums[5] = n5;
        nums[6] = n6;
        nums[7] = n7;
        nums[8] = n8;
        nums[9] = n9;
        int numLength = n.length();
        int x = 2 * s + 3;
        int y = s + 2;

        for (int i = 0; i < 5; i++) {
            //세로
            if(i%2==0) {
                for (int j = 0; j < numLength; j++) {
                    //가로
                    for (int k = 0; k < 3; k++) {
                        //숫자
                        if (nums[n.charAt(j) - '0'][i][k] == -1) {
                            System.out.print(" ");
                        } else if (nums[n.charAt(j) - '0'][i][k] == 1) {
                            for (int a = 0; a < s; a++) {
                                System.out.print("-");
                            }
                        } else {
                            for (int a = 0; a < s; a++) {
                                System.out.print(" ");
                            }
                        }
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            else {
                for(int l = 0;l<s;l++) {
                    for(int j=0;j<numLength;j++) {
                        for(int k=0;k<3;k++) {
                            if (nums[n.charAt(j) - '0'][i][k] == -1) {
                                for (int a = 0; a < s; a++) System.out.print(" ");
                            }else if (nums[n.charAt(j) - '0'][i][k] == 1) {
                                System.out.print("|");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
