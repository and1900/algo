package leetcode;

public class RemoveElement {
	
	// 2 pointers i and j, i keeps ++, j tracks result array
	public int removeElement(int[] A, int elem) {
		int j=0;
		int i=0;
		for (; i < A.length; i++) {
			if(A[i] != elem){
				A[j] = A[i];
				j++;
				
			}
		}
		return j;
	}
}
