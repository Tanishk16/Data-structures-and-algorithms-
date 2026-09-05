class Solution {
    public int firstStableIndex(int[] nums, int k) {
        //
        int max = Integer.MIN_VALUE;
        int minAns = Integer.MAX_VALUE;
        int[] preMax = new int[nums.length];
        int[] sufMin = new int[nums.length];
        int n = nums.length;
        // step 1:
        // we first find prefixMax array 
        preMax[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            preMax[i] = Math.max(preMax[i-1], nums[i]);
        }
        // Step 2:
        // now sufMin array
        sufMin[n-1] = nums[n-1];
        for(int i =n-2;i>=0;i--){
            sufMin[i] = Math.min(sufMin[i+1], nums[i]);
        }
        // Step 3 :
        // Final computation
        for(int i = 0;i<nums.length;i++){
            if(preMax[i] - sufMin[i] <= k){
                minAns = Math.min(i, minAns);
            }
        }
        if(minAns == Integer.MAX_VALUE){
            return -1;
        }
        return minAns;
    }
}