// Kadane's Algorithm, LargestSumContiguousSubarray
class subArray1 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i]+sum < nums[i]) sum=nums[i];
            else sum=nums[i]+sum;
            if(max<sum) max = sum;
        }
        return max;
    }
}