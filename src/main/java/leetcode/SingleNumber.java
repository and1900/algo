package leetcode;


import org.junit.Assert;
import org.junit.Test;

public class SingleNumber {
	//xor all the elements - xor is commutative and associative
	public int singleNumber(int[] A) {
		int single = 0;
		for(int i : A){
			single ^=i;
		}
		return single;
	}
	
	@Test
	public void test(){
		int[] arr = {2,2,3,4,4};
		Assert.assertEquals(3, singleNumber(arr));
	}
}
