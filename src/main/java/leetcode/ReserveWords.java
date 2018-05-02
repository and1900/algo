package leetcode;

//Reverse Words in a String
public class ReserveWords {

	public static void main(String[] args) {
		String s =  " Hello	my    world! ";
		System.out.println(reverseWords(s));
	}
	
	public static String reverseWords(String s) {
		if (s == null) {
			return s;
		}

		if (s.trim().isEmpty()) {
			return "";
		}
	
		String[] words = s.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i] + " ");
		}

		return sb.toString().trim();
	}

}
