package 알고리즘._01_정렬;

import java.util.Arrays;

public class Sort {
    /*
        [버블정렬]
        자료수 -1 개만큼의 사이클을 돌면서 대수비교

        [6 5] 3 1
        5 [6 3] 1
        5 3 [6 1]
        [5 3] 1 6
        3 [5 1] 6
        3 1 [5 6]
        [1 3] 5 6
        1 [3 5] 6
        1 3 [5 6]
    */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /*
        [선택정렬] O(n^2)
        n-1번의 사이클을 돌면서 최소값을 정렬되지 않은 값들 중 제일 앞에 오도록 swap

        4, 6, 1, 3, 5, 2
        >> [1round, min:1] 1, 6, 4, 3, 5, 2
        >> [2round, min:2] 1, 2, 4, 3, 5, 6
        >> [3round, min:3] 1, 2, 3, 4, 5, 6
        >> [4round, min:4] 1, 2, 3, 4, 5, 6
        >> [5round, min:5] 1, 2, 3, 4, 5, 6
    */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;
            for (int j = i; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /*
        [삽입정렬]
        4 6 1 3 5 2
        >>> [1 round] | 4 | 6 1 3 5 2
        >>> [2 round] 4 | 6 | 1 3 5 2, 4 vs 6
        >>> [3 round] 4 6 | 1 | 3 5 2, 6 vs 1 : swap, 4 vs 1 : swap
        >>> [4 round] 1 4 6 | 3 | 5 2, 6 vs 3 : swap, 4 vs 3 : swap, 1 vs 3
        >>> [5 round] 1 3 4 6 | 5 | 2, 6 vs 5 : swap, 4 vs 5
        >>> [6 round] 1 3 4 5 6 | 2 |, 6 vs 2 : swap, 5 vs 2 : swap, 4 vs 2 : swap, 3 vs 2 : swap, 1 vs 2
    */
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i;
            while(j >= 1) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
                --j;
            }
        }
        return arr;
    }

    /*
        [병합정렬]
        https://youtu.be/QAyl79dCO_k
        쪼갤 수 있을 때까지 배열을 앞과 뒤, 둘로 쪼갠 뒤,
        두 배열의 앞 원소를 비교하여 정렬된 배열의 앞부분부터 추가하여 합치면서
        정렬된 한 배열로 합친다.

        6 2 4 1 3 7 5 8
        6 2 4 1             | 3 7 5 8
        6 2 | 4 1
        2 6 | 1 4
        1 // 2 6 | 4
        1 2 // 6 | 4
        1 2 4 6
                            3 7 | 5 8
                            3 7 | 5 8
                            3 // 7 | 5 8
                            3 5 // 7 | 8
                            3 5 7 8
        1 // 2 4 6 | 3 5 7 8
        1 2 // 4 6 | 3 5 7 8
        1 2 3 // 4 6 | 5 7 8
        1 2 3 4 // 6 | 5 7 8
        1 2 3 4 5 // 6 | 7 8
        1 2 3 4 5 6 7 8
    */
    public static int[]  mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = ( start + end ) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid+1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        // 임시 저장소에 정렬이 된 만큼 복사하기
        for(int i=start; i<=end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start; // 1번째 배열의 첫번째 원소 인덱스
        int part2 = mid + 1; // 2번째 배열의 첫번째 원소 인덱스
        int index = start; // 양쪽 배열에서 작은 값을 하나씩 복사 할 때, 결과 배열의 몇 번째 인덱스에 저장할 것인가?

        // 1번째 배열의 끝까지 가거나, 2번째 배열의 끝까지 갈 때가지 반복문을 돌린다.
        while(part1  <= mid && part2 <= end) {
            // 양쪽 배열을 비교해서 1번째 배열의 원소값이 더 작다면 그 값을 결과 배열에 복사한다.
            if(tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++; // 저장할 배열의 index 는 어떤 쪽의 원소값이 더 크던 간 하나씩 늘려야 한다.
        }

        // 만약 2번째 배열은 비었는데 1번째 배열에 남은 데이터가 있는 경우를 대비해서
        // 앞 쪽 포인터가 배열의 끝에서 남은 만큼을 돌면서 최종적으로 저장할 배열에 남은 값들을 붙여준다.
        for (int i=0; i<= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }

        // 만약 1번째 배열은 비었는데 2번째 배열에 남은 데이터가 있는 경우는
        // 최종 배열의 뒤쪽에 이미 자리하고 있기 때문에 뒤쪽에 남은 데이터는 신경 안 쓰고 그냥 놔둬도 된다.
    }

}

class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 1};
        System.out.println(Arrays.toString(Sort.bubbleSort(new int[]{6, 5, 3, 1})));
        System.out.println(Arrays.toString(Sort.selectionSort(new int[]{4, 6, 1, 3, 5, 2})));
        System.out.println(Arrays.toString(Sort.insertSort(new int[]{4, 6, 1, 3, 5, 2})));
        System.out.println(Arrays.toString(Sort.mergeSort(new int[]{6, 2, 4, 1})));
    }
}
