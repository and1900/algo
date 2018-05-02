package leetcode;

//Write a function to find the longest common prefix string amongst an array of strings.
//leet code online judge expects "" if no common prefix
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            if(strs[0] != null && strs[0].length() > 0){
                return strs[0];
            } else {
                return "";
            }
        }


        String result = longestCommonPrefix(strs[0], strs[1]);

        String current = "";
        for (int i = 1; i < strs.length - 1; i++) {
            current = longestCommonPrefix(strs[i], strs[i+1]);
            if(current.length() == 0) {
                return "";
            }

            result = longestCommonPrefix(result, current);
            if(result.length() == 0){
                return "";
            }
        }
        return result;
    }

    private static String longestCommonPrefix(String a, String b){
        if(a == null || b == null || a.length() == 0 || b.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if(a.charAt(i) == b.charAt(i)){
                sb.append(a.charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String[] arr = {"c", "c"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(arr));
    }

}
