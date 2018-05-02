package leetcode;
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int i = -1;
        System.out.println(reverse(i));
    }

    private static int reverse(int x) {
        //int limit = Integer.MAX_VALUE / 10;

        int res = 0;
        int temp;
        while(x != 0){
            temp = x % 10;
            x = x / 10;
//            if(Math.abs(x) > limit){
//                return 0;
//            }
            if((res*10)/10 != res){
                return 0;
            }
            res = res * 10 + temp;
        }
        return res;
    }
}
