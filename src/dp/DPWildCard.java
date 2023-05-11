package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class DPWildCard {
    /*입력의 첫 줄에는 테스트 케이스의 수 C (1 <= C <= 10) 가 주어진다.
     각 테스트 케이스의 첫 줄에는 와일드카드 문자열 W 가 주어지며, 그 다음 줄에는 파일명의 수 N (1 <= N <= 50) 이 주어진다.
     그 후 N 줄에 하나씩 각 파일명이 주어진다.
     파일명은 공백 없이 알파벳 대소문자와 숫자만으로 이루어져 있으며, 와일드카드는 그 외에 * 와 ? 를 가질 수 있다.
     모든 문자열의 길이는 1 이상 100 이하이다.*/
    LinkedList<String> ret = new LinkedList<>();
    boolean[] checked;

    public void wildCardStart() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner in = new Scanner(System.in);

        int C = in.nextInt();
        in.nextLine();
        for (int i = 0; i < C; i++) {
            String W = in.nextLine();
            int N = in.nextInt();
            in.nextLine();
            String[] str = new String[N];
            for (int j = 0; j < N; j++) {
                str[j] = in.nextLine();
            }

            for (String a : str) {
                checked = new boolean[a.length()];
                if (wildCardValidation(W, a))
                    ret.add(a);
                checked=null;
            }

        }
    }

    private boolean wildCardValidation(String w, String a) {
        //W를 탐색한다.
        int index = 0;
        int aIndex = 0;
        int aLength = a.length();



        //와일드 카드가 없을 때 -> w와 a의 인덱스를 한칸식 앞으로 이동하며 문자 비교 후 끝까지가면 완료
        if ( !(w.contains("?") || w.contains("*")))
            return w.equals(a);
        while(aIndex == a.length()) {

            if(w.charAt(index) == '?') {
                index++; aIndex++;
            }else if(w.charAt(index) == '*') {
                char nextC = w.charAt(index+1);
                while(nextC == a.charAt(aIndex)) {
                    aIndex++;
//                    if()
                }
            }
        }
        /*
        와일드 카드가 맨처음 있을때 or 중간에 있을 때 or 마지막에 있을때
        ?가 맨처음에 있을 때
        *가 맨처음에 있을 때

        ?가 중간에 있을 때
        *가 중간에 있을 때

        ?가 마지막에 있을 때
        *가 마지막에 있을 때
         */
        if (w.charAt(index) == '?') {
            checked[index] = true;
            index++; aIndex++;
        } else if (w.charAt(index) == '*') {
            char nextC = w.charAt(index+1);
            while(nextC == a.charAt(aIndex)) {
                aIndex++;
//                if(aIndex == aLength && )
            }
        } else {

        }
        //맨처음 와일드 카드가 나올때까지 index 확인
        //앞에 와일드카드가 있다면
        return false;
    }
}
