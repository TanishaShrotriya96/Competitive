import java.util.*;
import java.io.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>(nums.length);
        for(int i=0;i<nums.length;i++){
            table.put(nums[i],i);
        }
        int pair[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(table.get(diff)!=null && table.get(diff)!=i){
                pair[0]=i;
                pair[1]=table.get(diff);
                break;
            }        
        }
       return pair;
    }
}