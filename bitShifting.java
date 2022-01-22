public class bitShifting {
    	public static void main(String args[]){
		
		// SIGNED Bit Shifting.
		
		// Shift to the right by 1 bit.
		//100 to 010
		System.out.println(4>>1);
		//100 to 1000
		System.out.println(4<<1);
		
		// Shift to the left by 1 bit.
		//1100 to 1010 
		System.out.println(-4>>1);
		//1100 to 11000
		System.out.println(-4<<1);
		//10000000to 100000000
		
		byte c = -128;
		// this is of type integer
		System.out.println(c<<1);
		System.out.println(Integer.class.isInstance(c<<1));
		
		//UNSIGNED Bit Shifting.
		
		// no such thing as <<< because we will always bring in a 0 in the LSB.
		//System.out.println(4<<<1);
		//10000.....00000100 to 0100...00010
		// frankly don't understand this. :) 
		System.out.println(-4>>>1);
		
    }
}