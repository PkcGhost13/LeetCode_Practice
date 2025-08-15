public class Test{
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        int result = maxProduct(nums);
        System.out.println("Maximum product of subarray: " + result);
    }
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        int max = 0;
        dp[0]=nums[0];
        for (int i = 1; i + i < n; i++) {
            int prod = 
            if((dp[i-1]*dp[i])>dp[i-1])
            {
                dp[i]=dp[i-1]*dp[i];
                System.out.println(dp[i]);
                max=Math.max(dp[i],max);
            }
            else{
                dp[i]=1;
            }
        }
        return max;
    }
}