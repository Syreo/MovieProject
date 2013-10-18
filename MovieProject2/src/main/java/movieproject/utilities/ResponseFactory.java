/**
 * 
 */
package movieproject.utilities;

import movieproject.response.Response;

import org.springframework.stereotype.Component;



/**
 * @author hyoung
 *
 */
@Component
public class ResponseFactory {

	
	public Response getResponse(){
		return new Response();
	}
	
}
