import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTests {
    @Test
    public void calculate_1plus1_returns2(){
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate("1+1");

        assertThat(result).isEqualTo(2);
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("1+1", 2),
                arguments("1+2", 3),
                arguments("2+2", 4),
                arguments("8+9", 17),
                arguments("4*5", 20),
                arguments("40+5", 45)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    public void calculate_addingTwoSingleDigits_returnsCorrectResult
            (String input, int expectedResult){
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate(input);

        assertThat(result).isEqualTo(expectedResult);
    }
}
