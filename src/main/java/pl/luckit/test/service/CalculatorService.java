package pl.luckit.test.service;

import org.springframework.stereotype.Service;
import pl.luckit.test.exception.InvalidInputValueException;
import pl.luckit.test.model.CalculatorResult;
import pl.luckit.test.validator.AddInputValidator;
import pl.luckit.test.validator.DivideInputValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    public CalculatorResult add(Double val1, Double val2) throws InvalidInputValueException {
        if (!AddInputValidator.isValid(val1, val2)) {
            throw new InvalidInputValueException();
        }
        return new CalculatorResult(BigDecimal.valueOf(val1).add(BigDecimal.valueOf(val2)));
    }

    public CalculatorResult divide(Double val1, Double val2) throws InvalidInputValueException {
        if (!DivideInputValidator.isValid(val1, val2)) {
            throw new InvalidInputValueException();
        }
        return new CalculatorResult(BigDecimal.valueOf(val1).divide(BigDecimal.valueOf(val2), 2, RoundingMode.HALF_UP));
    }
}
