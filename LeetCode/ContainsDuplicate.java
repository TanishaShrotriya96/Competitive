//LeetCode

import java.util.*;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> counter = new HashMap<Integer,Integer>();
        
        for(int i = 0; i<nums.length;i++){
            if(counter.get(nums[i])!=null){
                return true;
            }
            else {
                counter.put(nums[i],1);
             }
        }
        return false;
    }
}