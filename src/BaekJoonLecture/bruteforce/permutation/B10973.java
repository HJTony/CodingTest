package BaekJoonLecture.bruteforce.permutation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B10973 {
    static int[] list;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        int[] ans = go(list);
        if (ans != null) {
            for (int a : ans) {
                System.out.print(a + " ");
            }
        } else
            System.out.println(-1);
    }

    private static int[] go(int[] a) {
        int index = 0;
        int j = 0;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i-1] > a[i]) {
                index = i;
                break;
            }
        }
        if(index == 0) {
            return null;
        }
//        if (index == 0) {
//            return null;
//        }
        j = index - 1;
        int k = a.length-1;
        for(int m=index;m<a.length;m++) {
            if(a[j] <= a[m]) {
                k = m-1;
                break;
            }
        }
        int t = a[k];
        a[k] = a[j];
        a[j] = t;
        for (int i = index, n = a.length - 1; i < n; i++, n--) {
            int temp = a[i];
            a[i] = a[n];
            a[n] = temp;
        }
        return a;
    }
    //1. i를 끝에서 부터 찾는다 (어떤수의 첫번째 순열인지 확인) 만약 i가 0번째라면 마지막 순열이다( -1 출력)
    //2. i-1번째를 저장한다.
    //3. i보다 큰 값중에 가장 작은 값을 선택한다 i > a[j] 중 제일 작은 값(맨 오른쪽에 있는 값) 오른쪽에서 부터 감소하다가 아니면 리턴
    //4. i와 swap한다.
    //5. a[i]를 뒤집는다.
}
