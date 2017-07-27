package vom.imk.springBootUserService.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Used to build an exception model
 * @author issaoumo
 *
 */

@JsonPropertyOrder
public class BuildExceptionModel  {

 
	
	private String statusCode;
	private String message;
	private String cause;
	
	
	
	
	public BuildExceptionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	public BuildExceptionModel(String errorCode ,String message, String cause) {
		super();
		this.statusCode= errorCode;
		this.message= message;
		this.cause=cause;
		
	}
	 
	public String getStausCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	
	

}
