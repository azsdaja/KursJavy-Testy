import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CalculatorTests {
    @Test
    public void MojPierwszyTest(){
        org.assertj.core.api.Assertions.assertThat(1).isEqualTo(1);

        Subcalculator subcalculator = mock(Subcalculator.class);
        Calculator calculator = new Calculator(subcalculator);

        int sum = calculator.Add(5, 6, 7);

        Calculator mockedCalculator = mock(Calculator.class);

        mockedCalculator.Add(1, 2);
        mockedCalculator.Add(8, 0);
        /*verify(mockedCalculator, times(0)).Add(8, 2);
        verify(mockedCalculator, times(1)).Add(1, 2);
        verify(mockedCalculator, times(1)).Add(8, 0);
        verify(mockedCalculator, times(2)).Add(anyInt(), anyInt());



        verify(subcalculator, times(3)).Add(anyInt(), anyInt());
        verify(subcalculator, times(1)).Add(0, 5);
        verify(subcalculator, times(1)).Add(5, 6);
        verify(subcalculator, times(1)).Add(11, 7);*/

        assertThat(1).isEqualTo(2);
    }
}
