package tree;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static tree.TreeTestData.*;
import static util.TestUtility.toStr;

class BinaryTreePostorderTraversal145Test {

    private BinaryTreePostorderTraversal145 instance = new BinaryTreePostorderTraversal145();

    @ParameterizedTest(name = "Recursive Test : [{index}]")
    @MethodSource("testDataForPostOrder")
    @DisplayName("Test Recursive Method")
    void testRecursive(final TreeNode root, final String expectedOutput) {
        assertThat(toStr(instance.postorderTraversalRecursive(root)))
                .isEqualTo(expectedOutput);
    }

    @ParameterizedTest(name = "Iterative Test : [{index}]")
    @MethodSource("testDataForPostOrder")
    @DisplayName("Test Iterative Method Big tree")
    void testIterative(final TreeNode root, final String expectedOutput) {
        assertThat(toStr(instance.postorderTraversal(root)))
                .isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> testDataForPostOrder() {
        return Stream.of(
                arguments(getTreeOne(), "3,2,1"),
                arguments(getTreeTwo(), "1,3,2"),
                arguments(getTreeThree(), "4,5,2,3,1"),
                arguments(getTreeFour(), "4,12,10,18,24,22,15,31,44,35,66,90,70,50,25")
        );
    }
}