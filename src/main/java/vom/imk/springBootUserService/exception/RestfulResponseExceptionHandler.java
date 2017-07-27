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

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<BuildExceptionModel> numberFormatExceptionExceptionHandler(NumberFormatException ex)  {
        String message = "PLEASE ENTER A NUMBER ! Or YOUR NUMBER GREATER THAN INTEGER VALUE ";
        String status = HttpStatus.BAD_REQUEST.toString();
        BuildExceptionModel exModel = new BuildExceptionModel(status, message,ex.getMessage());
        return new ResponseEntity<BuildExceptionModel>(exModel, HttpStatus.BAD_REQUEST);

    }
    
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
    
   
//    @ExceptionHandler(value = MyException.class)
//    public ResponseEntity<CarException> generalExceptionHandler(MyException ex)  {
//        String cause = "YO ARE CALLING MYEXCEPTION !";
//        CarException exModel = new CarException(ex.getStatus(), cause,ex.getMessage());
//        return new ResponseEntity<CarException>(exModel, HttpStatus.BAD_REQUEST);
//
//    }

}
