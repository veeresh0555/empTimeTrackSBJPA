/**
 * 
 */
package com.hcl.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.hcl.model.ErrResponse;

/**
 * @author veeresh
 *
 */


@RestControllerAdvice
public class RestAdviceController {

	@ExceptionHandler(value =RecordsNotFound.class )
	public ErrResponse handleException(RecordsNotFound rnotfound) {
		ErrResponse excresponse=new ErrResponse("HCL-001", rnotfound.getMessage());
		return excresponse;
	}
	
	@ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrResponse constraintViolationException(ConstraintViolationException ex) {
        return new ErrResponse("400", "Bad Request");
    }
	
	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrResponse unknownException(Exception ex) {
        System.out.println(ex.getCause().toString());
        return new ErrResponse("500", "Internal Server Error");
    }
	
	
	@ExceptionHandler(value = { NoHandlerFoundException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrResponse noHandlerFoundException(Exception ex) {
        return new ErrResponse("404", "Resource Not Found");
    }
	
	
	
	
	
}
