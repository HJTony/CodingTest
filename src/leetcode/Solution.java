package leetcode;

class Solution {
    public void test(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;
    }
    public int removeDuplicates(int[] nums) {
        int k =1; //count, the numbers of unique

        int temp = nums[0];
        int[] tempArray = new int[nums.length];
        tempArray[0] = nums[0];

        for(int i=1;i<nums.length;i++) {
            if(nums[i] == temp) //값이 이전이랑 똑같을때
                continue;
            else {
                temp = nums[i];
                tempArray[k] = temp;
                k++;
            }
        }

        //nums <- tempArray 복사
        //1. nums 초기화
        for(int i=0;i<nums.length;i++) {
            nums[i] = 0;
        }
        //2. tempArray 값을 nums 복사
        for(int i=0;i<nums.length;i++) {
            nums[i] = tempArray[i];
        }
        return k;
    }
}