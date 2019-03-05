package misc;

public class Test {
	
	
	static int  countAlphabets(String[] words) {
		char c = 'a';
		int count = 0;
		
		for( int i = 0 ;i < 26 ; i++ ) {
			c = (char)('a' + i);
			if( presentInAllStrings( c, words)) {
				count ++;
			}
		}
		return count;
	}

	private static boolean presentInAllStrings(char c, String[] words) {
		for( int i = 0 ; i < words.length ; i++ ) {
			if(  ! words[i].contains( "" +c)) 
				return false; 
		}
		System.out.println(c);
		return true;
	}

	public static void main(String[] args) {

			String[] a = { "aazbc" , "acsdzbdd" , "dfdfbzdfd"};
			 int b = countAlphabets(a);
			System.out.println(b);
			
	}

}
