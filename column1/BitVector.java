public class BitVector {
	private int[] vector = new int[1];
	private final int bitsPerWord = 32;
	private final int rotateWord = 1;
	private final int clearWord = 0;
	
	public void setBit(int x) {
		if (x > vector.length * bitsPerWord) {
			//reallocate array to bigger size
			int newSize = x / bitsPerWord + 1; 
			int[] newArray = new int[newSize];
			for(int i=vector.length -1; i >= 0 ; i--) {
				newArray[i] = vector[i];
			}
			vector = newArray;
		}
		//set bit
		int insertIntoByte = x /bitsPerWord;
		int rotateTimes = x % bitsPerWord;

		try {
			vector[insertIntoByte] = vector[insertIntoByte] | (rotateWord << rotateTimes);
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Invalid input.");
		}
	}

	public int getBit(int x) {
		//Handles all out of bounds errors
		int getFromByte = -1;
		try {
			getFromByte = vector[x / bitsPerWord];
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Invalid input");
		}
		
		int rotateTimes = x % bitsPerWord;
		int resultByte = getFromByte & (rotateWord << rotateTimes);
		return resultByte >> rotateTimes;	
	}
	
	public void clear() {
		for(int i=0; i<vector.length; i++) {
			vector[i] = vector[i] & clearWord; 
		}
	}

	public static void main(String args[]) {
		BitVector b = new BitVector ();
		b.setBit(2);
		b.setBit(64);
		System.out.println(b.getBit(5));
		System.out.println(b.getBit(64));
		System.out.println(b.vector.length);
	}
}
