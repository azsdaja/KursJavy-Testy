import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CalculatorTests {

    @Test
    public void add_addingMoreThan2Numbers_returnsCorrectResult(){
        // to będzie test „czarnej skrzynki”

        // arrange
        Subcalculator subcalculator = new Subcalculator();
        Calculator calc = new Calculator(subcalculator);

        // act
        int result = calc.Add(1, 2, 3, 50);

        // assert
        assertThat(result).isEqualTo(56);
    }

    @Test
    public void add_addingMoreThan2Numbers_correctlyCallsSubcalculator(){
        // to będzie test „białej skrzynki”

        // arrange
        Subcalculator subcalculator = spy(Subcalculator.class);
        Calculator calc = new Calculator(subcalculator);

        // act
        calc.Add(1, 2, 5);

        // assert
        verify(subcalculator, times(3)).Add(anyInt(), anyInt());
        verify(subcalculator, times(1)).Add(0, 1);
        verify(subcalculator, times(1)).Add(1, 2);
        verify(subcalculator, times(1)).Add(3, 5);
        verifyNoMoreInteractions(subcalculator);
    }
}
