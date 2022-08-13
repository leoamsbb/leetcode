package array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRanges228Test {

    private final SummaryRanges228 testObject = new SummaryRanges228();

    @Test
    @DisplayName("should return correct result when empty array input")
    void givenEmptyArrayAsInput_thenReturnEmptyList() {
        final var result = testObject.summaryRanges(new int[] {});
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("should return correct result when input list contains single element")
    void testWhenTheInputListContainsSingleElement() {
        final var result = testObject.summaryRanges(new int[] {1});
        assertThat(result)
                .hasSize(1)
                .containsExactly("1");
    }

    @Test
    @DisplayName("should return correct result when input array is a straight sequence")
    void givenInputAsStraightSequence_thenReturnCorrectRanges() {
        final var result = testObject.summaryRanges(new int[] {1,2,3,4,5,6});
        assertThat(result)
                .hasSize(1)
                .containsExactly("1->6");

        final var anotherResult = testObject.summaryRanges(new int[] {6,7,8,9,10});
        assertThat(anotherResult)
                .hasSize(1)
                .containsExactly("6->10");
    }

    @Test
    @DisplayName("[1] should return correct result when input array is not a straight sequence")
    void givenInputNotStraightSequence_thenReturnCorrectRanges_01() {
        final var result = testObject.summaryRanges(new int[] {0,1,2,4,5,7});
        assertThat(result)
                .hasSize(3)
                .containsExactly("0->2", "4->5", "7");
    }

    @Test
    @DisplayName("[2] should return correct result when input array is not a straight sequence")
    void givenInputNotStraightSequence_thenReturnCorrectRanges_02() {
        final var anotherResult = testObject.summaryRanges(new int[] {0,2,3,4,6,8,9});
        assertThat(anotherResult)
                .hasSize(4)
                .containsExactly("0", "2->4", "6", "8->9");
    }
}