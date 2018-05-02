package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    // sliding window
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        //loop subString length 2 to s.length
        int result = 1;
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (!hasRepeatingChars(s.substring(j, j + i))){
                    result = i;
                    break;
                }
            }

            // Note: if no match for current length, no need to try longer substring
            if(result != i){
                break;
            }

        }

        return result;
    }

    private static boolean hasRepeatingChars(String s) {
        //save collection if length is 2
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return true;
            } else {
                set.add(c);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "aaaabcde";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring(s));

//        System.out.println(hasRepeatingChars("aa"));
//        System.out.println(hasRepeatingChars("ab"));
//        System.out.println(hasRepeatingChars("abcda"));
    }
}
