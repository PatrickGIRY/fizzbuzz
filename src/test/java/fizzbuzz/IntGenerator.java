package fizzbuzz;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.stream.IntStream;

public class IntGenerator extends Generator<Integer> {

    private PositiveAndMulitpleOf positiveAndMulitpleOf;

    public IntGenerator() {
        super(int.class);
    }

    @Override
    public Integer generate(SourceOfRandomness random, GenerationStatus status) {
        if (positiveAndMulitpleOf != null) {
            int mulipleOf = positiveAndMulitpleOf.value();
            return IntStream.generate(random::nextInt)
                    .filter(v -> v > 0) //
                    .filter(v -> v % mulipleOf == 0) //
                    .findFirst().orElse(mulipleOf);
        } else {
            return random.nextInt();
        }
    }

    public void configure(PositiveAndMulitpleOf positiveAndMulitpleOf) {
        this.positiveAndMulitpleOf = positiveAndMulitpleOf;
    }
}
