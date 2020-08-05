package 알고리즘._99_문제풀이.easy._05_비트연산;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class HammingDistance {
    /* --------------------------------------------------------------------------------------------------
        461. Hamming Distance
        (https://leetcode.com/problems/hamming-distance/)

        The Hamming distance between two integers
        is the number of positions at which the corresponding bits are different.

        Given two integers x and y, calculate the Hamming distance.

        Note:
        0 ≤ x, y < 2^31.

        Example:

        Input: x = 1, y = 4

        Output: 2

        Explanation:
        1   (0 0 0 1)
        4   (0 1 0 0)
               ↑   ↑

        The above arrows point to positions where the corresponding bits are different.
    --------------------------------------------------------------------------------------------------------- */
    public Queue<Integer> parseBitNumber(int num) {
        // 큐로 링크드리스트를 사용하자.
        LinkedList<Integer> bitNums = new LinkedList<>();

        while(num > 0) {
            bitNums.add(num % 2);
            num /= 2;
        }

        return bitNums;
    }

    public int hammingDistance(int x, int y) {
        Queue<Integer> bitX = parseBitNumber(x);
        Queue<Integer> bitY = parseBitNumber(y);

        int distance =  0;
        while(!bitX.isEmpty() && !bitY.isEmpty()) {
            Integer frontX = bitX.remove();
            Integer frontY = bitY.remove();
            if(!frontX.equals(frontY)) {
                distance++;
            }
        }
        while(!bitX.isEmpty()) {
            Integer front = bitX.remove();
            if (front.equals(1)) {
                distance++;
            }
        }
        while(!bitY.isEmpty()) {
            Integer front = bitY.remove();
            if (front == 1) {
                distance++;
            }
        }

        return distance;
    }

    /*
        (https://youtu.be/KNs8KhLIOdc)
        a = 3 -> 11
        b = 2 -> 10

        a & b = 10 (둘 다 1이여야 -> 1)
        a | b = 11 (둘 중 하나가 1이면 -> 1)
        a ^ b = 01 (두 비트가 다르면 1, 아니면 0)

        a >> i (a의 모든 비트를 오른쪽으로 i칸 밀고, 맨 왼쪽으로 0으로 채움)
        a << i (a의 모든 비트를 왼쪽으로 i칸 밀고, 맨 오른쪽으로 0으로 채움)

        a >> 1 = 01
        a << 1 = 10
    */
    public int hammingDistance_best(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        // 자바에서 integer는 4바이트니까 32bit -> 32번 돌아야 함
        for(int i=0; i<32; i++) {
            cnt += (xor >> i) & 1;
        }
        return cnt;
    }

    @Test
    public void hammingDistanceTest() {
        assertEquals(hammingDistance_best(1, 4), 2);
    }
}
