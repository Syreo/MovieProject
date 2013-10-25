package movieproject.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import movieproject.controller.UserController;
import movieproject.dao.UserDao;
import movieproject.entities.User;
import movieproject.response.Response;
import movieproject.utilities.ResponseFactory;
import movieproject.utilities.UserFactory;

import javax.servlet.http.HttpServletRequest;




import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


/**
 * Registration Class
 * 
 * @author hyoung
 *
 */
@Component
public class Registration {

	@Autowired
	private UserDao userDao;


	private static final String ENTERTEXT = "Enter ";
	private UserFactory userFactory = new UserFactory();
	private ResponseFactory responseFactory = new ResponseFactory();
		/**
		 * createUser Registers a user and persists them to the database
		 */
		public Response createUser(String firstName, String lastName, String userName, String email, String password, HttpServletRequest request) {
			Response response = responseFactory.getResponse();
			response = new Response();
			RegEx regEx = new RegEx();
			int userRole = 2;
			String userNameTakenError = "The username you have chosen is already in use! Please try again with a different username.";
			String emptyInputError = "Please fill out all fields before submitting!";
			
			List<String>errorList = new ArrayList<String>();
			/*
			 * Grabs errors from regex page
			 */

			String emailError = regEx.badEmailCheck(email);
			String passwordError = regEx.badPasswordCheck(password);
			String userNameError = regEx.badUserNameCheck(userName);
			
			DateTime newTimeStamp= new DateTime();
			DateTimeFormatter format = DateTimeFormat.forPattern("dd MMM yyyy HH:mm").withLocale(Locale.US);
			String userJoinDate = format.print(newTimeStamp);
			
			/*
			 * Checks to make sure that the input fields are not blank. If any are
			 * submitted blank then it returns an error and returns user to the
			 * registration page.
			 */
			
			if (firstName.indexOf(ENTERTEXT) != -1
					|| lastName.indexOf(ENTERTEXT) != -1
					|| userName.indexOf(ENTERTEXT) != -1) {
				errorList.add(emptyInputError);
				response.setResponse(errorList);
				return response;
			}
			/*
			 * Checks to see if the RegEx class returned any validation errors. If
			 * it does return errors then they're added as attributes and sent to
			 * the registration page.
			 */
			
			
			if (emailError != null || passwordError != null
					|| userNameError != null) {
				
				errorList.add(emailError);
				errorList.add(passwordError);
				errorList.add(userNameError);
				response.setResponse(errorList);
				return response;

			}
			
			User temp = userDao.findByUserName(userName);
			/*
			 * Checks to see if the username entered is already in use. If it is
			 * then the method returns an error and returns to the registration
			 * page.
			 */
			if (temp == null) {

				User user = userFactory.getUser();
				user = new User(firstName, lastName, userName, password, email, userJoinDate, userRole);

				userDao.persist(user);
				
				response.setSuccess("Success");
				response.setResponse(user);
				return response;
				/*
				 * Adds userNameTakenError message as an attribute and sends it to
				 * the registration page.
				 */
			} else {
				
				errorList.add(userNameTakenError);
				response.setResponse(errorList);
				return response;
			}
		}


	
}
