package tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static tree.TreeTestData.*;
import static util.TestUtility.toStr;

class BinaryTreePreorderTraversal144Test {
    private final BinaryTreePreorderTraversal144 instance = new BinaryTreePreorderTraversal144();


    @ParameterizedTest(name = "Recursive : [{index}]")
    @MethodSource("testDataForPreorder")
    void testRecursive(final TreeNode root, final String expectedOutput) {
        assertThat(toStr(instance.preorderTraversalRecursive(root)))
                .isEqualTo(expectedOutput);
    }

    @ParameterizedTest(name = "Iterative : [{index}]")
    @MethodSource("testDataForPreorder")
    void testIterative(final TreeNode root, final String expectedOutput) {
        assertThat(toStr(instance.preorderTraversal(root)))
                .isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> testDataForPreorder() {
        return Stream.of(
                arguments(getTreeOne(), "1,2,3"),
                arguments(getTreeTwo(), "2,3,1"),
                arguments(getTreeThree(), "1,2,4,5,3"),
                arguments(getTreeFour(), "25,15,10,4,12,22,18,24,50,35,31,44,70,66,90")
        );
    }
}