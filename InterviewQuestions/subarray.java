/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
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
          long final_index = -1;

          for(int i = 0 ; i<Integer.parseInt(params[0]);i++) {

            long d = Long.valueOf(data[i]);
            
            if(d < sum) {

              // if((sum_so_far + d) <= sum ) {

                sum_so_far = sum_so_far + d;
                final_index=i;
                System.out.println("(sum_so_far + d) < sum "+sum_so_far);
                
//               }
              
              while(sum_so_far > sum) {
                  
                  long temp = Long.valueOf(data[initial]);
                  sum_so_far = sum_so_far - temp;
                  initial=initial+1;
                  System.out.println("sum_so_far > sum"+sum_so_far);
              }
                
              
              if(sum_so_far == sum) { 
                result[cnt++] = initial+1+" "+(final_index+1)+"";
                System.out.println("Found subarray");
                break;
              }

              else if(i == Integer.parseInt(params[0]) - 1) {
                result[cnt++] = ""+(-1);
              }



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