public class NumberUtils {
    public static int getNumericSumIteration (int number) {
        int sum = 0;
        int currentNumber = number;
        while (currentNumber != 0) {
            sum += currentNumber % 10;
            currentNumber /= 10;
        }
        return sum;
    }

    public static long getNumericSumRecurrent (long number) {
        return getNumericSumRecurrent(number, 0);
    }

    private static long getNumericSumRecurrent (long number, long sum) {
        if (number != 0) {
            return getNumericSumRecurrent(number / 10, sum + number % 10);
        }
        else return sum;
    }
}
