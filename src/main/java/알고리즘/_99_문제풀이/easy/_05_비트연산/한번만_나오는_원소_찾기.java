package 알고리즘._99_문제풀이.easy._05_비트연산;

public class 한번만_나오는_원소_찾기 {
    /*
        136. Single Number

        Given a non-empty array of integers, every element appears twice except for one.
        Find that single one.

        Note:
            Your algorithm should have a linear runtime complexity.
            Could you implement it without using extra memory?

        Example 1:
            Input: [2,2,1]
            Output: 1
            Example 2:

        Input: [4,1,2,1,2]
            Output: 4
     */
    public static int singleNumber1(int[] nums) {
        int temp;
        for(int i=0; i<nums.length; ++i) {
            temp = nums[i];
            boolean isDouble = false;
            for(int j=0; j<nums.length; ++j) {
                if(i==j) continue;
                if(temp == nums[j]) {
                    isDouble = true;
                }
            }
            if(isDouble == false) {
                return temp;
            }
        }
        return -1;
    }

    public static int singleNumber2(int[] nums) {
        // XOR
        // n^n = 0
        // n^0 = n
        int ret = 0;
        for(int num: nums) ret ^= num;
        return ret;
    }

    public static void main(String[] args) {
        int rv = singleNumber1(new int[]{2, 2, 1});
        System.out.println(rv);
    }
}
