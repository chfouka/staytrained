import java.util.ArrayList;
import java.util.BitSet;

public class ArrayStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "76fgb12";
		char[] s = test.toCharArray();

		sort(s, 0, s.length);
		duplicate(s);
		
		//mergeso
		//System.out.println(s);
		
		//char[] s = {'a', 'f', 'k', '\n'};
		//System.out.println(s.length);
		//char[] t = mergesort(s);
		//System.out.println(unique(test.toCharArray()));
		
		//revert(s);
		System.out.println(s);
	}
	
	
	/**** 
	 * Implement an algorithm to determine if a string has all unique characters
	 */
	static boolean unique( char[] s ){
		BitSet 	mask = new BitSet();
		
		for(char c: s){
			if (mask.get(c))
				return false;
			mask.set(c);
		}
		return true;
	}
	
	/** same as before without using additional data structures 
	 * */
	
	
	static char[] mergesort(char[] s){
		if (s.length == 1)
			return s;
		
		int center = s.length / 2  ;
		int rst = s.length % 2;
		
		char[] s1 = new char[center];
		char[] s2 = new char[center + rst];
		int k = 0;
		
		for(int i = 0; i<center; i++){
			s1[i] = s[k];
			k++;
		}
		
		for(int i = 0; i<center + rst; i++){
			s2[i] = s[k];
			k ++;
		}
		
		//System.out.println(s1);
		//system.out.println(s2);
		
		char[] t1 = mergesort(s1);
		char [] t2 = mergesort(s2);
		
		return merge(t1, t2);
		//return null;
		
	}
	
	
	static char[] merge(char[] s1, char[] s2){
		char[] r = new char[s1.length + s2.length]; 
		int k = 0;
		int i = 0;
		int j = 0;
		
		while( (i< s1.length) && (j< s2.length) ){
			if(s1[i] < s2[j]){
				r[k] = s1[i];
				i++;
				k++;
			}
			
			else{
				r[k] = s2[j];
				j++;
				k++;
			}
		}
		
		for( ; i< s1.length; i++){
			r[k] = s1[i];
			k ++;
		}
		
		for(; j< s2.length; j++){
			r[k] = s2[j] ;
			k ++;
		}		
			
	
		
		//System.out.println(s);
			
		return r;
		
	}
	
	/** 
	 * 
	 * @param s: string
	 * @param sx: inclusive
	 * @param dx: exclusive
	 */
	
	static void sort ( char [] s, int sx, int dx ){
		//control empty string
		
		if ( sx == dx )
			return;
		
		// controls, 1 char string
		if ( (dx - sx) == 1 )
			return;
					
				
		
		int center =  sx + ( (  dx - sx ) / 2 );
		
		sort ( s, sx, center );		
		sort ( s, center, dx);
		__merge ( s, sx, center, dx );
		
	}
	
	
	static void __merge(char[] s, int sx, int center, int dx ){		
		//allocate a string of dx - sx elements, the result
		char[] b = new char [ dx - sx ];
		
		//System.out.println( dx - sx );
		
		int i = sx;
		int j = center;
		int k = 0;
		
		while ( ( i < center) && ( j < dx )  ){
			
			if (s[i] < s[j]){
				b[k] = s[i] ;
				i++;
				k++;
			}
				
			else{
				b[k] = s[j];
				j++;
				k++;
			}
				
		}
		
		//copy the rest in b
		
		for(; i < center; i++){
			b[k] = s[i];
			k++;
		}
		
		
		for(; j < dx ; j++){
			b[k] = s[j];
			k++;
		}
		
	//	System.out.println(b);
		
		//copy directly b in s to save space
		for( int t = 0; t < b.length; t++ ){
			//System.out.println(sx + ' ' + t);
			s[sx] = b[t];
			sx ++;
			
			
		}
		
	}
	
	
	static boolean uniqueness( char[] s){
		char [] t = mergesort(s);
		
		int i = 0;
		while( i < t.length - 1 ){
			if( t[i] == t[i+1] )
				return false;
			i++;
		}
		return true;
	}
	
	
	 /** Write code to reverse a C-Style String. 
	  * C-style means that we have null char at the
	  * end '\n'
	  */
	
	static char[] reverse( char[] s ){
		if(s.length == 2)
			return s;
		
		else {
			char[] t = new char[s.length-1];
			for(int i = 0; i< s.length - 1; i++)
				t[i] = s[i];
			
			char[] sm = reverse (t);
			
			char[] res = new char[sm.length + 1];
			int k = 0;
			for(; k<res.length - 1; k++)
				res[k] = sm[k];
			res[k] = s[0];
			
			return res;
		}	
		
	}
	
	
	static void revert ( char[] s ){
		
		int i = 0;
		int j = s.length - 2;
		char tmp = 0;
		while (  i < j ){
			tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			i++;
			j--;
		}
			
				
	}
	
	
	
	/**
	 * remove duplicate from
	 * the input string s
	 */
	
	static void duplicate( char[] s ) {
		// one sol is to order the string and after that
		// with two indexes one read and one write 
		
		//mergesort( s );	
		int i = 0; // read
		int j = 0; // write
		
		while (  i < s.length - 1  ){
			while( s[i] == s[i+1] )
				i ++;
			
			s[j] = s[i];
			j ++;
			i ++;
		}
		
		s[j] = s[i];
		s[ j + 1 ] = '\n';
	}
	
	 
	

}
