class Solution {
    private int robLinear(int l, int r, int[] nums) {
        int n = nums.length-1;
        int[] dp = new int[n];

        dp[0] = nums[l];
        dp[1] = Math.max(nums[l+1], nums[l]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i+l]);
        }
        return dp[n-1];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        else if(n == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(robLinear(0, n-1, nums), robLinear(1, n, nums)) ;     
    }
}
