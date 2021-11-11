package InterviewQuestions;

// Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

// Output:
// For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10^7
// 1 <= Ai <= 10^10

// Example:
// Input:
// 2
// 5 12
// 1 2 3 7 5
// 10 15
// 1 2 3 4 5 6 7 8 9 10
// Output:
// 2 4
// 1 5

// NOTE: Size limit on arrays is Integer.MAX_VALUE

/*package whatever //do not write package name here */

import java.io.*;

class Solution {
  public static void main (String[] args) {
    try {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

      int t = Integer.parseInt(read.readLine());
      int cnt = 0;
      
      String result[] = new String[t];
      while(t > 0){

          String params[] = read.readLine().trim().split(" ");
          String data[] = read.readLine().trim().split(" ");
        
          long sum = Long.parseLong(params[1]);
          long sum_so_far = 0;
        
          int initial = 0;

          for(int i = 0 ; i<Integer.parseInt(params[0]);i++) {

            
           System.out.println("initial = "+initial);
           System.out.println("Sum_so_far = "+sum_so_far+" i = "+ (i-1));
           long d = Long.parseLong(data[i]);
            
           sum_so_far = sum_so_far + d; 
            
           while(sum_so_far > sum && initial < i) {
            
             sum_so_far = sum_so_far - Long.parseLong(data[initial]);
             initial = initial + 1;
             System.out.println("When initial at = "+initial+"sum_so_far = "+ sum_so_far);
             
           }
            
           
           System.out.println("After adding i = "+i+" sum_so_far = "+ sum_so_far); 
            
           if(sum_so_far == sum) {
             
             result[cnt++] = initial+1+" "+(i+1)+"";
             break;
             
           } 
          
           
           if(i == Integer.parseInt(params[0]) - 1 && sum_so_far != sum) {
                result[cnt++] = ""+(-1);
                 
           }
             
        }
        
        t=t-1;

      }
      
      for(int i = 0 ; i < cnt ; i++){
        System.out.println(result[i]);
      }
      
    }
    catch (Exception e) {
    
    }
  }
}