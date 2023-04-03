import org.example.HomeWork1.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorTests2Hamcrest {
    Calculator calculator;

    @BeforeEach
    public void beforeEach(){
        calculator = new Calculator();
    }
    @AfterEach
    public void afterEach(){
        calculator = null;
    }
@Test
    public void instanceTest() {
    Calculator expected = Calculator.instance.get();
        assertThat(expected, instanceOf(Calculator.class));
    }

    @Test
    public void plusTest() {
        int expected = 4, a = 2, b = 2;

        int result = calculator.plus.apply(a, b);


        assertThat(expected,equalTo(result));
    }

    @Test
    public void minusTest() {
        int expected = 0, a = 2, b = 2;

        int result = calculator.minus.apply(a, b);


        assertThat(expected,equalTo(result));
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void multiplyTest(int a, int b, int expected) {
        int result = calculator.multiply.apply(a, b);

        assertThat(expected,equalTo(result));
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(3, 3, 9),
                Arguments.of(9, 0, 0));

    }

    @Test
    public void devideTest() {
        int expected = 1, a = 2, b = 2;

        int result = calculator.devide.apply(a, b);


        assertThat(expected,equalTo(result));
    }

    @Test
    public void powTest() {
        int expected = 4, a = 2;

        int result = calculator.pow.apply(2);

        assertThat(expected,equalTo(result));
    }

    @ParameterizedTest
    @MethodSource("methodSource2")
    public void absTest(int a, int expected){

        int result = calculator.abs.apply(a);

        assertThat(expected,equalTo(result));
    }

    public static Stream<Arguments> methodSource2(){
        return Stream.of(
                Arguments.of(4,4),
                Arguments.of(-4,4)
        );
    }

    @Test
    public void isPositiveTest(){
        boolean expected = true; int a = 5;

        boolean result = calculator.isPositive.test(a);

        assertThat(expected,equalTo(result));
    }
}
