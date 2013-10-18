/**
 * 
 */
package movieproject.response;

import org.springframework.stereotype.Component;

/**
 * @author Hannah
 *
 */
@Component
public class Response {

	
	private String success;
	private String error = "";
	private Object response;
	
	
	public Response(){
		
	}


	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}


	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}


	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}


	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}


	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}


	/**
	 * @param response the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}
	
	
	
	
}
