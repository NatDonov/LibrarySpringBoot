package co.jb.authors.advice;

import co.jb.authors.exceptions.LibraryCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryControllerAdvice {

    @ExceptionHandler(value = {LibraryCustomException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handler(Exception exception){

        return new ErrorDetails("library system error", exception.getMessage());
    }
}
