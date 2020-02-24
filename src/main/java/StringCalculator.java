public class StringCalculator {
    public int calculate(String input) {
        String firstNumberString = input.substring(0, 1);
        String secondNumberString = input.substring(2, 3);

        int firstNumber = Integer.parseInt(firstNumberString);
        int secondNumber = Integer.parseInt(secondNumberString);

        return firstNumber + secondNumber;
    }
}
