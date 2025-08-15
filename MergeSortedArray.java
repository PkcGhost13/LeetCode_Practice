package LeetCode_Practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        Set<Integer> uniqueElements = new HashSet<>((Arrays.stream(nums1).boxed().toList()));
        uniqueElements.addAll(Arrays.stream(nums1).boxed().toList());
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 5;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        mergeSortedArray.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
