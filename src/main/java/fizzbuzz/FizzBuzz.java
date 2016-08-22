package fizzbuzz;

public class FizzBuzz {
    public static String fizzbuzz(int value) {
        if (value > 0 && value % 5 == 0) {
           return "Buzz";
        }
        else if (value > 0 && value % 3 == 0) {
            return "Fizz";
        } else {
            return String.valueOf(value);
        }
    }
}
