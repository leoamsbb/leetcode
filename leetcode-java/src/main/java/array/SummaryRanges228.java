package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class SummaryRanges228 {

    public List<String> summaryRanges(int[] nums) {
        final var inputSize = nums.length;
        if (inputSize == 0) {
            return List.of();
        } else if (inputSize == 1) {
            return List.of(getRange(nums[0]));
        } else if (inputSize == nums[inputSize - 1] - nums[0] + 1) {
            return List.of(getRange(nums[0], nums[inputSize - 1]));
        } else {
            final var result = new ArrayList<String>();
            int from = 0;
            int current;
            int next;
            int index = 0;
            while (index < inputSize) {
                if (index == 0) {
                    from = nums[0];
                }
                current = nums[index];
                if (index + 1 == inputSize) {
                    if (current == from)
                        result.add(getRange(from));
                    else
                        result.add(getRange(from, current));
                } else {
                    next = nums[index + 1];
                    if (next > current + 1) {
                        if (current == from)
                            result.add(getRange(current));
                        else
                            result.add(getRange(from, current));
                        from = next;
                    }
                }
                index++;
            }

            return result;
        }
    }

    private String getRange(final int num) {
        return String.format("%d", num);
    }

    private String getRange(final int from, final int to) {
        return String.format("%d->%d", from, to);
    }
}
