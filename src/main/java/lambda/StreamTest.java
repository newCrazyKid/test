package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(list.stream().reduce(10, Integer::sum));
    }
}
