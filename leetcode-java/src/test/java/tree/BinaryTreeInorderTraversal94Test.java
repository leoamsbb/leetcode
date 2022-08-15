package tree;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static tree.TreeTestData.*;
import static util.TestUtility.toStr;

class BinaryTreeInorderTraversal94Test {

    private final BinaryTreeInorderTraversal94 instance = new BinaryTreeInorderTraversal94();


    @ParameterizedTest(name = "Recursive : [{index}]")
    @MethodSource("testDataForInorder")
    void testRecursive(final TreeNode root, final String expectedOutput) {
        assertThat(toStr(instance.inorderTraversalRecursive(root)))
                .isEqualTo(expectedOutput);
    }

    @ParameterizedTest(name = "Iterative : [{index}]")
    @MethodSource("testDataForInorder")
    void testIterative(final TreeNode root, final String expectedOutput) {
        assertThat(toStr(instance.inorderTraversal(root)))
                .isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> testDataForInorder() {
        return Stream.of(
                arguments(getTreeOne(), "1,3,2"),
                arguments(getTreeTwo(), "1,3,2"),
                arguments(getTreeThree(), "4,2,5,1,3"),
                arguments(getTreeFour(), "4,10,12,15,18,22,24,25,31,35,44,50,66,70,90")
        );
    }
}