package 알고리즘._99_문제풀이.easy._08_해쉬;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    시간복잡도 <-> 공간복잡도

    [대안]
        1. brute-force 모든 조합을 시도.
            - 시간: n*(n-1) / 2 (O(n^2))
            - 공간: O(1)
        2. 해쉬맵 사용, 루프 1개 돌면서 이미 봤던 값을 해쉬맵에 넣음.
            - 시간: O(n)
            - 공간: O(n)

    * 해쉬맵의 경우 검색에 O(1) 의 시간 복잡도가 걸린다.
*/

public class TwoSum {
    /*
        1. Two Sum
        (https://leetcode.com/problems/two-sum/description/)
        (https://youtu.be/FHphOv2mmIA)
        (https://youtu.be/ly-zKS3ubYo)

        Given an array of integers,
        return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution,
        and you may not use the same element twice.

        Example:
            Given nums = [2, 7, 11, 15], target = 9,
            Because nums[0] + nums[1] = 2 + 7 = 9,
            return [0, 1].

     */
    public static int[] twoSum(int[] nums, int target) {
        // 대안 2 해쉬맵 사용
        Map<Integer, Integer> map = new HashMap<>(); // key: 값, value: index

        for(int i=0; i<nums.length; ++i) {
            int cur = nums[i];
            if(map.containsKey(target-cur)) {
                int[] ret = new int[2];
                ret[0] = cur;
                ret[1] = target-cur;
                return ret;
            } else {
                map.put(cur, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
}
