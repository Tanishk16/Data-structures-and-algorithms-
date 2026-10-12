class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) nums[i] %= k;

        int l = 0, r = 0;
        int mx = 1;

        while (r < n) {
            if (nums[l] != nums[r]) {
                l = r;
            }

            long sum = 1L * nums[r] * (r - l + 1);

            if (sum % k == nums[r]) {
                mx = Math.max(mx, r - l + 1);
            }

            r++;
        }

        return mx;
    }
}