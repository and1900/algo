package leetcode;

public class StrIndexOf {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.substring(i).startsWith(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrIndexOf().strStr("abcd", "c"));
    }


}
