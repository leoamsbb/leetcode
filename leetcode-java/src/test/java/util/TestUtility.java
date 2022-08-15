package util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestUtility {

    public static final <T> String toStr(List<T> result) {
        String res = result.stream().map(Objects::toString).collect(Collectors.joining(","));
        System.out.println("Result: " + res);
        return res;
    }

}
