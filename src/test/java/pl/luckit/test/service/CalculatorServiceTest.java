package pl.luckit.test.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.luckit.test.exception.InvalidInputValueException;
import pl.luckit.test.model.CalculatorResult;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    static Stream<Arguments> validAddInputValues() {
        return Stream.of(
                Arguments.arguments(1.2, 1.3, BigDecimal.valueOf(2.5)),
                Arguments.arguments(1.0, 2.0, BigDecimal.valueOf(3.0)),
                Arguments.arguments(0.0, 0.0, BigDecimal.valueOf(0.0)),
                Arguments.arguments(-100.0, 10.0, BigDecimal.valueOf(-90.0)),
                Arguments.arguments(10.333333333, 10.555555555, BigDecimal.valueOf(20.888888888))
        );
    }

    @ParameterizedTest
    @MethodSource("validAddInputValues")
    void shouldCallAddMethodAndReturnCorrectResult(Double inputVal1, Double inputVal2, BigDecimal expected) throws InvalidInputValueException {
        //given
        //when
        CalculatorResult result = calculatorService.add(inputVal1, inputVal2);
        //then
        assertThat(result.getResult()).isEqualTo(expected);
    }

    static Stream<Arguments> invalidAddInputValues() {
        return Stream.of(
                Arguments.arguments(1.2, null),
                Arguments.arguments(null, null),
                Arguments.arguments(null, 1.3)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidAddInputValues")
    void shouldCallAddMethodAndThrowInvalidInputValueException(Double inputVal1, Double inputVal2) {
        assertThrows(InvalidInputValueException.class,
                () -> calculatorService.add(inputVal1, inputVal2));
    }

    static Stream<Arguments> validDivInputValues() {
        return Stream.of(
                Arguments.arguments(10.0, 5.0, new BigDecimal("2.00")),
                Arguments.arguments(-10.0, -5.0, new BigDecimal("2.00")),
                Arguments.arguments(-10.0, 5.0, new BigDecimal("-2.00")),
                Arguments.arguments(10.0, -5.0, new BigDecimal("-2.00")),
                Arguments.arguments(0.0, 23.0, new BigDecimal("0.00")),
                Arguments.arguments(123.123532, 53211.231, new BigDecimal("0.00")),
                Arguments.arguments(999.99, 123.3333, new BigDecimal("8.11"))
        );
    }

    @ParameterizedTest
    @MethodSource("validDivInputValues")
    void shouldCallDivideMethodAndReturnCorrectResult(Double inputVal1, Double inputVal2, BigDecimal expected) throws InvalidInputValueException {
        //given
        //when
        CalculatorResult result = calculatorService.divide(inputVal1, inputVal2);
        //then
        assertThat(result.getResult()).isEqualTo(expected);
    }

    static Stream<Arguments> invalidDivInputValues() {
        return Stream.of(
                Arguments.arguments(1.2, null),
                Arguments.arguments(null, null),
                Arguments.arguments(null, 1.3),
                Arguments.arguments(1.3, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidDivInputValues")
    void shouldCallDivideMethodAndThrowInvalidInputValueException(Double inputVal1, Double inputVal2) {
        assertThrows(InvalidInputValueException.class,
                () -> calculatorService.divide(inputVal1, inputVal2));
    }
}