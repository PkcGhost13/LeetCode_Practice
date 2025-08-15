package LeetCode_Practice;
public class ArrayCopyExample {
    public static void main(String[] args) {
        int[] sourceArray = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int[] destArray = { 15, 25, 35, 45, 55, 65, 75, 85, 95, 105 };

        System.arraycopy(sourceArray, 0, destArray, 0, sourceArray.length);

        System.out.print("Final destArray: ");
        for (int i : destArray) {
            System.out.print(i + " ");
        }
    }
}
