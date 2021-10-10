//LeetCode

class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] front = new int[nums.length];
        int[] back = new int[nums.length];
        
        front[0] = nums[0];
        back[nums.length-1] = nums[nums.length-1];
        
        int index = nums.length - 1;
        
        for(int i=1;i<nums.length-1;i++){
            front[i] = front[i-1]*nums[i];
        }

        for(int i=nums.length-2;i>0;i--){
            back[i] = back[i+1] * nums[i];
        }
        nums[0] = back[1];
        nums[nums.length-1] = front[nums.length-2];
        
        for(int i = 1;i<nums.length-1;i++){    
            nums[i] = front[i-1]*back[i+1];
        } 
        return nums;
    }
}