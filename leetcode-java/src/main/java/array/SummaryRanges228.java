package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class SummaryRanges228 {

    public List<String> summaryRanges(int[] nums) {
        final var inputSize = nums.length;
        if (inputSize == 0) {
            return List.of();
        } else if (entireInputIsSequence(nums)) {
            return List.of(getRange(nums[0], nums[inputSize - 1]));
        } else {
            final var result = new ArrayList<String>();
            int from = 0;
            int index = 0;
            while (index < inputSize) {
                if (index == 0) {
                    from = nums[0];
                }
                int current = nums[index];
                if (isLastElement(inputSize, index)) {
                    result.add(checkFromWithCurrentAndGetRange(from, current));
                } else if (nums[index + 1] > current + 1) {
                    result.add(checkFromWithCurrentAndGetRange(from, current));
                    from = nums[index + 1];
                }
                index++;
            }

            return result;
        }
    }

    private boolean entireInputIsSequence(int[] nums) {
        int inputSize = nums.length;
        return inputSize != 1 && inputSize == nums[inputSize - 1] - nums[0] + 1;
    }

    private boolean isLastElement(int inputSize, int index) {
        return index + 1 == inputSize;
    }

    private String checkFromWithCurrentAndGetRange(int from, int current) {
        if (current == from)
            return getRange(current);
        else
            return getRange(from, current);
    }

    private String getRange(final int num) {
        return String.format("%d", num);
    }

    private String getRange(final int from, final int to) {
        return String.format("%d->%d", from, to);
    }
}
