// Find total number of Squares in a N*N cheesboard.

// Input:
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N that is the side of the chessboard.

// Output:
// Each seperate line showing the maximum number of squares possible.

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100

// Example:
// Input:
// 2
// 1
// 2

// Output:
// 1
// 5

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
  public static void main (String[] args) {
    //code
    
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int input[] = new int[t];
    
        for(int i = 0; i<t;i++) {
            input[i]=sc.nextInt();
        }
        
        
        for(int i = 0; i<t;i++) {
          
            int squares = 0;
            int n = input[i];
            
            while(n > 0) {
                squares = squares + n*n;
                n = n-1;
            }
            System.out.println(squares);
        }
        
        sc.close();
        
        
    }
}