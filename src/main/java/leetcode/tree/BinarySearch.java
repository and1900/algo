package leetcode.tree;

public class BinarySearch {
    public int binarySearch(int[] arr, int val) {

        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == val) {
                return mid;
            }

            if (val < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        throw new RuntimeException("Not found: " + val);
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        System.out.println(new BinarySearch().binarySearch(arr, 3));
    }
}
