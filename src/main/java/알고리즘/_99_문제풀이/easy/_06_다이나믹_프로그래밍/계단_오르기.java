package 알고리즘._99_문제풀이.easy._06_다이나믹_프로그래밍;
/*
    다이나믹 프로그래밍이란? 재귀적으로 구현 했을 때 시간복잡도가 넓어지는 것을
    부분문제의 결과값을 저장하고 재활용함으로써 공간을 좀 더 사용하고 시간 복잡도를 줄이기 위해 사용하는 방법

    푸는법? 점화식을 찾아내자!
*/
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class 계단_오르기 {
    /*
        70. Climbing Stairs
        (https://youtu.be/d0oiDbuSr-I)
        (https://leetcode.com/problems/climbing-stairs/submissions/)

        You are climbing a stair case. It takes n steps to reach to the top.

        Each time you can either climb 1 or 2 steps.
        In how many distinct ways can you climb to the top?

        Example 1:
            Input: 2
            Output: 2

            Explanation: There are two ways to climb to the top.
                1. 1 step + 1 step
                2. 2 steps

        Example 2:
            Input: 3
            Output: 3

            Explanation: There are three ways to climb to the top.
                1. 1 step + 1 step + 1 step
                2. 1 step + 2 steps
                3. 2 steps + 1 step

        Constraints:
            1 <= n <= 45
    */
    /******************  1. 내 방법 *******************************/
    int answer = 0;

    public int climbStairs_mine(int n) {
        answer = 0;
        int curPos = 0;
        List<Integer> steps = new ArrayList<>();
        System.out.println(Arrays.asList(steps).toString());
        climbStairs_mine(n, curPos, steps);
        return answer;
    }

    private void climbStairs_mine(int n, int curPos, List<Integer> steps) {
        if(n < curPos) {
            return;
        }
        if(n == curPos) {
            answer++;
            System.out.println(Arrays.asList(steps).toString());
            return;
        }
        climbStairs_mine(n, curPos+1, steps);
        climbStairs_mine(n, curPos+2, steps);
    }

    /******************  2. 피보나치로 풀기 *******************************/
    // 생각해보면 피보나치 수열 문제임
    // n칸을 올라가는 방법은 n-1 칸을 올라갔을 때 1칸 올라가거나 n-2 칸을 올라갔을 때 2칸 올라가면 되기 때문에
    // F(n) = F(n-1) + F(n-2) 를 만족함
    // 계단의 수 1 2 3 4 5 6
    // 방법의 수 1 2 3 5 8 11

    /******************  2-1. 재귀적 용법 *******************************/
    // 그냥 재귀구현을 하면 공간복잡도 O(1), 시간복잡도 O(2^n)
    // f(n) = f(n-1) + f(n-2)
    // f(5) = f(4) + f(3)
    // f(4) = f(3) + f(2)
    // f(3) = f(2) + f(1)

    /******************  2-2. 다이나믹 프로그래밍 *******************************/
    // 공간을 사용해서 내가 이미 계산한 값이면 거기서 꺼내오기. -> 다이나믹 프로그래밍
    // 다이나믹 프로그래밍으로 구현 시 공간 복잡도 O(n), 시간복잡도(n)
    // 점화식을 찾아야 한다.

    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int[] d = new int[n+1];
        d[1] = 1; d[2] = 2;

        for(int i=3; i<=n; ++i) {
            d[i] = d[i-1] + d[i-2];
        }

        return d[n];
    }

    @Test
    public void climbStairsTest() {
        assertEquals(climbStairs(2), 2);
        assertEquals(climbStairs(3), 3);
        assertEquals(climbStairs(4), 5);
        assertEquals(climbStairs(5), 8);
        assertEquals(climbStairs(6), 13);
    }

}
