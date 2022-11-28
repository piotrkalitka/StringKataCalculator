package pl.piotrkalitka;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KataCalcTest {

    private final KataCalc calc = new KataCalc();

    @Test()
    public void shouldSumValues() {
        assertEquals(1, calc.add("1"));
        assertEquals(3, calc.add("1,2"));
        assertEquals(6, calc.add("1,2,3"));
        assertEquals(210, calc.add("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20"));
    }

    @Test()
    public void shouldReturn0OnBlankInput() {
        assertEquals(0, calc.add(""));
        assertEquals(0, calc.add(null));
    }

    @Test()
    public void shouldHandleNewLinesInsteadOfDelimiter() {
        assertEquals(10, calc.add("1,2\n3\n4"));
    }

    @Test()
    public void shouldSupportSingleDelimiter() {
        assertEquals(6, calc.add("//[.]\n1.2.3"));
    }

    @Test()
    public void shouldSupportMultipleDelimiters() {
        assertEquals(10, calc.add("//[.][,][*]\n1.2,3*4"));
    }

    @Test()
    public void shouldSupportMultipleLongDelimiters() {
        assertEquals(10, calc.add("//[.][,][*****]\n1*****2,3*****4"));
    }

    @Test()
    public void shouldSkipGreaterThan1000() {
        assertEquals(1010, calc.add("1,2,3,4,1000"));
        assertEquals(10, calc.add("1,2,3,4,1001"));
    }

    @Test()
    public void shouldThrowExceptionWhen2DelimitersMeet() {
        assertThrows(IllegalArgumentException.class, () -> calc.add("1,2\n,3"));
    }

    @Test()
    public void shouldThrowExceptionOnNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> calc.add("1,2,3,-4"));
    }
}
