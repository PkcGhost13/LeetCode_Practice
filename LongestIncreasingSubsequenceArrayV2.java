package LeetCode_Practice;
public class LongestIncreasingSubsequenceArrayV2 {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int maxSubSequence = 0;
        int left = 0;
        int prevMax = nums[0];
        for (int right = 0; right < n - 1; right++) {
            if (nums[right] <= prevMax) {
                prevMax = nums[right];
                int sequenceSize = right - left + 1;
                maxSubSequence = Math.max(sequenceSize, maxSubSequence);
            } else {
                left = right;
            }
        }
        return maxSubSequence + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 6, 5, 3, 4, 2, 1 };
        int[] nums2 = { 10, 20, 10, 19, 10, 20 };
        int[] nums3 = { 16, 6, 3 };
        System.out.println(longestSubsequence(nums3));
        System.out.println(longestSubsequence(nums1));
        System.out.println(longestSubsequence(nums2));

    }
}
