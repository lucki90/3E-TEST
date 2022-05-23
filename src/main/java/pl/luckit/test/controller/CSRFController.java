package pl.luckit.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This controller exists only because the swagger calls the following endpoints by default,
 * because it checks if CSRF protection is enabled.
 * <p>
 * This small application does not have CSRF protection implemented,
 * so a redirection to swagger-ui has been added to avoid calling endpoints that are not handled.
 */
@ApiIgnore
@Controller
public class CSRFController {

    private static final String APPLICATION_JSON = "application/json;charset=UTF-8";

    @GetMapping(value = "/csrf", produces = APPLICATION_JSON)
    public String redirectFromCSRF() {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON)
    public String redirectFromDomain() {
        return "redirect:/swagger-ui.html";
    }
}
