package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class B2529 {
    static int k;
    static String[] a;
    static boolean[] c;
    static String[] signs;
    static ArrayList<String> list = new ArrayList<>();

    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        a = new String[k+1];
        c = new boolean[11];
        scanner.nextLine();
        signs = scanner.nextLine().split(" ");
        go(0);

        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    private static void go(int index) {
        if(index == k+1) {
//            if(check(a)){
                list.add(String.join("", a));
//            }
//                System.out.println(Arrays.toString(a));
            return;
        }
//        if(index > 1 && (Integer.parseInt(a[index-2]) > Integer.parseInt(a[index-1])) && !signs[index-2].equals(">")) return;
//        else if(index > 1 && (Integer.parseInt(a[index-2]) < Integer.parseInt(a[index-1]) )&& !signs[index-2].equals("<")) return;
        for(int i=0;i<=9;i++) {
            if(c[i]) continue;
            a[index] = String.valueOf(i);
            if(index == 0 || good(a[index-1], String.valueOf(i), signs[index-1])) {
                c[i] = true;
                go(index + 1);
                c[i] = false;
            }
        }
    }
    private static boolean good(String x, String y, String sign) {
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        if(a > b) {
            return sign.equals(">");
        }else if( a < b) {
            return sign.equals("<");
        }
        return false;
    }
    private static boolean check(String[] a) {
        for(int i=0;i<k;i++) {
            if(Integer.parseInt(a[i]) < Integer.parseInt(a[i+1])) {
                if(!signs[i].equals("<")) return false;
            }else if(Integer.parseInt(a[i]) > Integer.parseInt(a[i+1])) {
                if(!signs[i].equals(">")) return false;
            }
        }
        return true;
    }
}
