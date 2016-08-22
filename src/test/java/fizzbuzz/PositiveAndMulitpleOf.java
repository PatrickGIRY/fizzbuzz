package fizzbuzz;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.GeneratorConfiguration;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER})
@From(IntGenerator.class)
@Retention(RUNTIME)
@GeneratorConfiguration
public @interface PositiveAndMulitpleOf {

    int value() default 1;
}
