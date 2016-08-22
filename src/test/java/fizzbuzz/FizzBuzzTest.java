package fizzbuzz;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assume.assumeFalse;

@RunWith(JUnitQuickcheck.class)
public class FizzBuzzTest {

    @Property
    public void should_return_normal_number_as_string(int value) throws Exception {
        assumeFalse(value % 3 == 0);
        assumeFalse(value % 5 == 0);

        assertThat(FizzBuzz.fizzbuzz(value)).isEqualTo(String.valueOf(value));

    }
}
