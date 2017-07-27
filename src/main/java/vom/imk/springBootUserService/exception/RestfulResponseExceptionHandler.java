package vom.imk.springBootUserService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




/**
 * 
 * @author issaoumo
 * 
 * Global Level using -  @ControllerAdvice
 * 
 */


@ControllerAdvice
public class RestfulResponseExceptionHandler {

 
    
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<BuildExceptionModel> nullPointerExceptionHandler(NullPointerException ex)  {
        String message = "THE OBJECT IS NULL !";
        BuildExceptionModel exModel = new BuildExceptionModel(HttpStatus.BAD_REQUEST.toString(), message, ex.getMessage());
        return new ResponseEntity<BuildExceptionModel>(exModel, HttpStatus.BAD_REQUEST);

    }
    
    @ExceptionHandler(value =  IllegalArgumentException .class)
    public ResponseEntity<BuildExceptionModel> illegalArgumentExceptionHandler(IllegalArgumentException   ex)  {
        String message = "ILLEGAL ARGUMENT EXCEPTION  !";
        BuildExceptionModel exModel = new BuildExceptionModel(HttpStatus.BAD_REQUEST.toString(), message, ex.getMessage());
        return new ResponseEntity<BuildExceptionModel>(exModel, HttpStatus.BAD_REQUEST);

    }
    
 

}
