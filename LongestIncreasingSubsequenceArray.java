package LeetCode_Practice;
public class LongestIncreasingSubsequenceArray {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int[] diffSequence = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffSequence[i] = Math.abs(nums[i] - nums[i + 1]);
        }
        int maxSubSequence = 0;
        int left = 0;
        int prevMax = diffSequence[0];
        for (int right = 0; right < n - 1; right++) {
            if (diffSequence[right] <= prevMax) {
                prevMax = diffSequence[right];
                maxSubSequence = Math.max(maxSubSequence, right - left + 1);
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
