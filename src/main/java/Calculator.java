


public class Calculator {
    private Subcalculator subcalculator;

    public Calculator(Subcalculator subcalculator) {

        this.subcalculator = subcalculator;
    }

    public int Add(int... numbers) {
        int result = 0;
        for (int number : numbers) {
            result = subcalculator.Add(result, number);
        }
        return result;
    }
}

