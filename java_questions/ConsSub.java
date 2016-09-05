import java.lang.*;
import java.util.*;
class ConsSub {
	public static void main(String args[]) {
		int [] input = {1, 2, 3, 5, 6, 10, 11, 12, 13};
		int maxElement = maxNumber(input);
		boolean [] hash = new boolean [maxElement+1];
		for(int i=0; i<input.length; i++) hash[input[i]] = true;
		int maxSubSize = 0;
		int currSubSize = 0;
		boolean inSubArray = false;
		for(int i=0; i< hash.length; i++) {
			if(inSubArray == false) {
				if (hash[i] == false) 
					continue;
				else {
					inSubArray = true; 
					currSubSize++;
				}
			} else {
				if(hash[i] == false) {
					maxSubSize = Math.max(maxSubSize, currSubSize); 
					currSubSize = 0;
					inSubArray = false;
				} else {
					currSubSize++;
					if(i == hash.length-1) 
						maxSubSize = Math.max(maxSubSize, currSubSize);
				}
			}
		}
		System.out.println(maxSubSize);
	}

	public static int maxNumber(int [] x) {
		int max = 0;
		for(int i=0; i<x.length; i++) 
			max = Math.max(max, x[i]);
		return max;
	}
}
