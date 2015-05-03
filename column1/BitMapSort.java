import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class BitMapSort {
	
	public static final int MAXNUM = 20;

	public static void main(String args[]) {
		//Read input file into Bit vector	
		int[] arrayOfNumbers = new int[MAXNUM];
		arrayOfNumbers = generateRandom(arrayOfNumbers);
		int[] sortedArray = countingSort(arrayOfNumbers);
		System.out.println("Sorted array : " + Arrays.toString(sortedArray));
	}

	public static int[] generateRandom(int[] array) {
		ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer> ();
		Random randomGenerator = new Random();
		Integer trial1 = new Integer(randomGenerator.nextInt(MAXNUM));
		arrayOfNumbers.add(trial1);
		array[0] = trial1.intValue();
		for(int i=1; i<MAXNUM; i++) {
			Integer trial;
			do {
				trial = new Integer(randomGenerator.nextInt(MAXNUM));
			} while (arrayOfNumbers.contains(trial));
			arrayOfNumbers.add(trial);
			array[i] = trial.intValue();
		}
		System.out.println(Arrays.toString(array));
		return array;
	}

	public static int[] countingSort (int[] array) {
		BitVector integerArray = new BitVector();
		int[] sortedArray = new int[MAXNUM];
		for(int i=0; i<MAXNUM; i++) {	
			integerArray.setBit(array[i]);
		}
		int sortedCount = 0;
		for(int i=0; i<MAXNUM; i++) {
			if(integerArray.getBit(i) == 1) {
				sortedArray[sortedCount++] = i;
			}
		}
		return sortedArray;
	}
}
