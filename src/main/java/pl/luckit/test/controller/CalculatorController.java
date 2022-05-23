package pl.luckit.test.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import pl.luckit.test.exception.InvalidInputValueException;
import pl.luckit.test.model.CalculatorResult;
import pl.luckit.test.service.CalculatorService;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);
    private static final String ADD_ENDPOINT_LOG_MESSAGE = "Endpoint '/add' was called with the values: {} and {}";
    private static final String DIV_ENDPOINT_LOG_MESSAGE = "Endpoint '/div' was called with the values: {} and {}";
    private final CalculatorService calculatorService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public CalculatorResult add(@RequestParam @Nullable Double val1, @RequestParam @Nullable Double val2) throws InvalidInputValueException {
        LOG.info(ADD_ENDPOINT_LOG_MESSAGE, val1, val2);
        return calculatorService.add(val1, val2);
    }

    @GetMapping("/div")
    @ResponseStatus(HttpStatus.OK)
    public CalculatorResult divide(@RequestParam @Nullable Double val1, @RequestParam @Nullable Double val2) throws InvalidInputValueException {
        LOG.info(DIV_ENDPOINT_LOG_MESSAGE, val1, val2);
        return calculatorService.divide(val1, val2);
    }
}
