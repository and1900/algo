package leetcode;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

//TODO not complete
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if(S==null || S.isEmpty() || T==null || T.isEmpty()) return "";
		
        int p = 0;
        int q = S.length()-1;
        
        Map<Character, Integer> sMap = getCharCounts(S);
        Map<Character, Integer> tMap = getCharCounts(T);
        
        
        return S.substring(p,q);
    }

	private Map<Character, Integer> getCharCounts(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		char c;
		for(int i=0; i<s.length(); i++){
			c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		return map;
	}
	
	
	@Test
	public void getCharCounts(){
		String s = "abbccc";
		System.out.println(getCharCounts(s));
	}
}
