package leetcode;

import java.util.Arrays;

public class p26 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 4, 2, 2, 3};
//        int k = solution.removeDuplicates(nums);
//        System.out.println(k);
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        solution.test(nums);
        Arrays.stream
                (nums).forEach(System.out::print);


    }
}
