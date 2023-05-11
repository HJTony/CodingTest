package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//가장 긴 증가하는 부분수열 4
//역추적을 해서 LIS의 수열까지 구하기
public class B14002 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            d[i] = 1;
            c[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (a[i] > a[j] && d[i] <= d[j]) {
                    d[i] = d[j] + 1;
                    c[i] = j;
                }
            }
        }

        int size = 0;
        int index = 0;
        for(int i=0;i<n;i++) {
            if (size < d[i]){
                index = i;
                size++;
            }
        }
        int ans = size;
        ArrayList<Integer> list = new ArrayList<>();

        list.add(a[index]);
        int last = c[index];
        if(last >= 0) {
            do {
                list.add(a[last]);
                last = c[last];
                if(last <0 ) break;
            } while (c[last] >= 0);

            if(last >=0)
                list.add(a[last]);
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(ans);
        for(int i=0;i<ans ;i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
