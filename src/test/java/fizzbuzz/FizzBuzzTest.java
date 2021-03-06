package fizzbuzz;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static fizzbuzz.FizzBuzz.fizzbuzz;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

@RunWith(JUnitQuickcheck.class)
public class FizzBuzzTest {

    @Property
    public void should_return_normal_number_as_string(int value) throws Exception {
        assumeFalse(value % 3 == 0);
        assumeFalse(value % 5 == 0);

        assertThat(fizzbuzz(value)).isEqualTo(String.valueOf(value));
    }

    @Property
    public void should_return_Fizz_when_number_is_multiple_of_3(@PositiveAndMulitpleOf(3) int value) throws Exception {
        assertThat(fizzbuzz(value)).startsWith("Fizz");
    }

    @Property
    public void should_return_Buzz_when_number_is_multiple_of_5(@PositiveAndMulitpleOf(5) int value) throws Exception {
        assertThat(fizzbuzz(value)).endsWith("Buzz");
    }

    @Property
    public void should_return_FizzBuzz_when_number_is_multiple_of_3_and_multiple_of_5(@PositiveAndMulitpleOf(15) int value) throws Exception {
        assertThat(fizzbuzz(value)).isEqualTo("FizzBuzz");
    }
}
