import java.util.Arrays;

public class LargerThanFourNeighbours {
    public static void main(String args[]) {
        int[] nums = {10, 20, 30, 25, 20, 40, 10};
        int[] largerNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boolean isLarger = true;
            for (int j = -2; j <= 2; j++) {
                int neighbourIndex = i + j;
                if (neighbourIndex < 0 || neighbourIndex >= nums.length) {
                    continue;
                }
                if (nums[neighbourIndex] > nums[i]) {
                    isLarger = false;
                }
            }

            if (isLarger) {
                largerNums[i] = nums[i];
            }
        }

        int nonZeroCount = 0;
        for (int i = 0; i < largerNums.length; i++) {
            if (largerNums[i] != 0) {
                nonZeroCount += 1;
            }
        }

        int[] largerNumsStripped = new int[nonZeroCount];
        int pos = 0;
        for (int i = 0; i < largerNums.length; i++) {
            if (largerNums[i] != 0) {
                largerNumsStripped[pos] = largerNums[i];
                pos += 1;
            }
        }

        System.out.println(Arrays.toString(largerNumsStripped));
    }
}