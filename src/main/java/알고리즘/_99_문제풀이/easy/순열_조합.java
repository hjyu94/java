package 알고리즘._99_문제풀이.easy;

public class 순열_조합 {

    public static void main(String[] args) {
        순열(new int[]{1,2,3,4}, 3);
        조합(new int[]{1,2,3,4}, 3);
    }

    // 뽑은 얘들로 무언갈 하자
    private static void doSomething(int[] chosen) {
        for(int num : chosen) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /************************** 순열 *******************************************/
    // nums에서 n개를 뽑는다 - 중복해서 뽑아도 된다.
    private static void 순열(int[] nums, int n) {
        int[] chosen = new int[n]; // n개 뽑아서 저장할 공간
        순열(nums, chosen, n, 0);
    }

    private static void 순열(int[] nums, int[] chosen, int n, int depth) {
        if(depth == n) {
            for(int chosenNum : chosen) {
                System.out.print(chosenNum + " ");
            }
            System.out.println();
            return;
        }
        for(int num: nums) {
            chosen[depth] = num;
            순열(nums, chosen, n, depth+1);
        }
    }

    /************************** 조합 *******************************************/
    // nums 중에서 n개를 뽑는 조합
    private static void 조합(int[] nums, int n) {
        boolean[] isVisited = new boolean[nums.length];
        int[] chosen = new int[n]; // n개 뽑아서 저장할 공간
        조합(nums, chosen, isVisited, n, 0);
    }

    private static void 조합(int[] nums, int[] chosen, boolean[] isVisited, int n, int depth) {
        if(depth == n) {
            doSomething(chosen);
            return;
        }
        for(int i=0; i<nums.length; ++i) {
            if(isVisited[i] == false) {
                isVisited[i] = true;
                chosen[depth] = nums[i];
                조합(nums, chosen, isVisited, n, depth+1);
                isVisited[i] = false;
            }
        }
    }

}
