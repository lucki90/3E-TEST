package pl.luckit.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import static pl.luckit.test.exception.ExceptionMessageEnum.INVALID_PATH_MESSAGE;
import static pl.luckit.test.exception.ExceptionMessageEnum.INVALID_PATH_MESSAGE_PAGE;

@ApiIgnore
@Controller
public class ErrorRequestController implements ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorRequestController.class);

    @RequestMapping("/error")
    public ResponseEntity<Object> invalidPathException() {
        LOG.error(INVALID_PATH_MESSAGE.getMessage());
        return new ResponseEntity<>(INVALID_PATH_MESSAGE_PAGE.getMessage(), HttpStatus.NOT_FOUND);
    }
}
