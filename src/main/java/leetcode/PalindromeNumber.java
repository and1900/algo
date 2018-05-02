package leetcode;

//Determine whether an integer is a palindrome. Do this without extra space.
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int len = 0;
        int temp = x;
        while (temp > 0) {
            len++;
            temp = temp / 10;
        }
        int halfLen = len / 2; // even OK, odd also OK - ignore middle digit
        boolean isLenOdd = (len % 2 != 0);

        int left = x;
        int right = 0;
        for (int i = 0; i < halfLen; i++) {
            right = right * 10 + (left % 10);
            left = left / 10;
        }

        // len is ODD, 121  12 & 1, need to take out 1 more for left
        if (isLenOdd) {
            left = left / 10;
        }

        return left == right;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(131));
    }
}
