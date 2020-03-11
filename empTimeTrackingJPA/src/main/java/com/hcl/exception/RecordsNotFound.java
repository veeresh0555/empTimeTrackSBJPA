/**
 * 
 */
package com.hcl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author veeresh
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordsNotFound extends Exception {

	
	 	public RecordsNotFound() {
	        super();
	    }
	    public RecordsNotFound(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public RecordsNotFound(String message) {
	        super(message);
	    }
	    public RecordsNotFound(Throwable cause) {
	        super(cause);
	    }
	
	
	
}
