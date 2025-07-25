package zairastra.u5w2p.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zairastra.u5w2p.payloads.ErrorDTO;
import zairastra.u5w2p.payloads.ErrorsWithListDTO;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {

    //BAD REQUEST - 400
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleBadRequest(BadRequestException exception) {
        return new ErrorDTO(exception.getMessage(), LocalDateTime.now());
    }

    //BAD REQUEST - ERRORI DI VALIDAZIONE - 400
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsWithListDTO handleValidationErrors(ValidationException exception) {
        return new ErrorsWithListDTO(exception.getMessage(), LocalDateTime.now(), exception.getErrorMessages());
    }

    //NOTFOUNDEXCEPTION// - 404
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleNotFound(NotFoundException exception) {
        return new ErrorDTO(exception.getMessage(), LocalDateTime.now());
    }

    //ECCEZIONI NON GESTITE SINGOLARMENTE - 500
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleServerError(Exception exception) {
        exception.printStackTrace();//questo mi stampa in console lo stack trace per capire dove sta l'errore
        return new ErrorDTO("Ooops, we have a problem!", LocalDateTime.now());
    }
}
