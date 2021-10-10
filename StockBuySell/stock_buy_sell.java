// Goldman Sachs Question Format

import java.io.*;
import java.util.*;


class Solution {
  public static void main(String[] args) {
    try{
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      String[] result = new String[t];
      int cnt =0;
      BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
      Stack<Integer> indices = new Stack<Integer>();
      
      while(t > 0) {
        
        int n = sc.nextInt();
        String[] array = r.readLine().trim().split(" ");
        int initial =-1,final_ind=-1;
        
        for(int i=n-1;i>0;i--){
          
          int profit =Integer.parseInt(array[i]) - Integer.parseInt(array[i-1]);
          
          // System.out.print("profit "+profit+" ");
          
          if(profit > 0) {
            
            if(final_ind == -1) {
              final_ind = i;
            }
            
            initial = i-1;
          }

          if(profit <= 0) {
            
            if(initial != -1 && final_ind != -1){
               
               indices.push(final_ind);
               indices.push(initial);
               
            }
            
            final_ind = -1;
          }

          if(initial == -1 && i==1) {
            indices.push(-1);
          }
          
          if(i==1 && initial != -1 && final_ind != -1){
            
               indices.push(initial);
               indices.push(final_ind);
          }
          
        }
        // System.out.println();
        
        String s = "";
        int cntr = 0;
        
        while(indices.isEmpty() == false){
         
          String element = indices.pop().toString();
           // System.out.println(element);
          if(element.equals("-1")) {
            s="No Profit";
            break;
          }
          
          else if(cntr == 0){
            s=s.concat("(");
          }
          
          s=s.concat(element);
          cntr=cntr+1;
          
          if(cntr == 2) {
            s=s.concat(")");
            cntr=0;
          }
        }
        
//         System.out.println("There");
      
        result[cnt++] = s;
        t=t-1;
      }
      
      for(int i=0;i<result.length;i++){
        System.out.println(result[i]);
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}
