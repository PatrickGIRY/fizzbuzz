package fizzbuzz;

public class FizzBuzz {
    public static String fizzbuzz(int value) {
        if (value % 3 == 0) {
            return "Fizz";
        } else {
            return String.valueOf(value);
        }
    }
}
