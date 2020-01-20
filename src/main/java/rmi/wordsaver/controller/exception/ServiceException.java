package rmi.wordsaver.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "System Server Error")
public class ServiceException extends RuntimeException {
}
