package movieproject.helpers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;






import movieproject.dao.UserDao;
import movieproject.entities.User;
import movieproject.response.Response;
import movieproject.utilities.ResponseFactory;




import movieproject.utilities.UserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Login Class
 * @author hyoung
 *
 */
@Component
public class Login {
	
	@Autowired
	private UserDao userDao;
	
	private static final String USERNAME = "userName";
	private static final String LOGINERRORMESSAGE = "You have entered an incorrect Username and/or Password. Please try again.";
	private ResponseFactory responseFactory = new ResponseFactory();
	
	
	

	private String password;
	
	/**
	 *  Checks to see if username is already taken then sends to password checker. 
	 *  
	 * @param request
	 * @param model
	 * @param userDao
	 * @return
	 */
	public Response login(String userName, String password, final HttpServletRequest request) {
		List<String>errorList = new ArrayList<String>();
		Response response = responseFactory.getResponse();
		response = new Response();
		this.password = password;
	
		User temp = userDao.findByUserName(userName);
		
		
		if(temp == null){
			
			errorList.add(LOGINERRORMESSAGE);
			response.setResponse(errorList);
			
			return response;
			
		} else if (temp.getPassword().equals(password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userId", temp.getUserId());
				session.setAttribute("firstName", temp.getFirstName());
				session.setAttribute("lastName", temp.getLastName());
				session.setAttribute(USERNAME, temp.getUserName());
				response.setSuccess("Success");
				response.setResponse(temp);
				return response;
				
			}else{
				
				errorList.add(LOGINERRORMESSAGE);
				response.setResponse(errorList);
				
				return response;
			}
	}
	
}
