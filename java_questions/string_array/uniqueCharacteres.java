package string_array;
import java.util.Stack;

class uniqueCharacters {

	public static void main(String args[]) {
		uniqueCharacters uC = new uniqueCharacters();
		String s = "sameer";
		System.out.println(uC.isUniqueChar(s));
		String p = "priya";
		System.out.println(uC.isUniqueChar(p));
	}
	
	boolean isUniqueChar(String l) {
		Stack<Character> s = new Stack();
		for( int i=0; i<l.length(); i++) {
			boolean unique = compare(l.charAt(i), s);
			if (unique)
				s.push(l.charAt(i));
			else	
				return false;
		}
		return true;
	}

	boolean compare(char c, Stack<Character> s){
		while(!s.isEmpty()) {
			Character x = s.pop();
			if(x.equals(c))
				return false;
		}
		return true;
	}
}
