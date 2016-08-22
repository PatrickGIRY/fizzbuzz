package fizzbuzz;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static fizzbuzz.FizzBuzz.Rule.rule;
import static java.util.stream.Collectors.joining;

public class FizzBuzz {
    public static String fizzbuzz(int value) {

        RuleChecker ruleChecker = RuleChecker.fromValue(value);
        return mayBe(value, Stream.of(rule(3, "Fizz"), rule(5, "Buzz")).filter(ruleChecker).map(rule -> rule.s).collect(joining()));

    }

    private static String mayBe(int value, String s) {
        return s.isEmpty() ? String.valueOf(value) : s;
    }

    static class Rule {
        private final int multipleOf;
        private final String s;

        public static Rule rule(int multipleOf, String s) {
            return new Rule(multipleOf, s);
        }

        private Rule(int multipleOf, String s) {
            this.multipleOf = multipleOf;
            this.s = s;
        }
    }

    private interface RuleChecker extends Predicate<Rule> {
        static RuleChecker fromValue(int value) {
            return rule -> value > 0 && value % rule.multipleOf == 0;
        }
    }
}
