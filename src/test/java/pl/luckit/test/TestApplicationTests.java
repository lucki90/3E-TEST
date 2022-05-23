package pl.luckit.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.luckit.test.controller.CalculatorController;
import pl.luckit.test.service.CalculatorService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CalculatorController calculatorController;

    @Test
    void contextLoads() {
        assertThat(calculatorController).isNotNull();
        assertThat(calculatorService).isNotNull();
    }
}
