package movieproject.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;








import movieproject.dao.UserDao;
import movieproject.entities.User;
import movieproject.helpers.Login;
import movieproject.helpers.Registration;
import movieproject.helpers.UserProfile;
import movieproject.response.Response;
import movieproject.utilities.ResponseFactory;

import org.hibernate.Hibernate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * UserController
 * 
 * @author hyoung
 * 
 */
@Controller
public class UserController {

	private String INVALIDATE_ERROR = "ERROR: COULD NOT INVALIDATE SESSION";

	@Autowired
	private UserDao userDao;

	@Autowired
	private Registration register;

	@Autowired
	private Login login;
	
	@Autowired
	private UserProfile userProfile;

	private ResponseFactory responseFactory = new ResponseFactory();

	/**
	 * Retrives user information for login.
	 * 
	 */
	@RequestMapping(value = "/UserRetrieve", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response retrieve(final HttpServletRequest request, final Model model) {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		return login.login(userName, password, request);
	}

	/**
	 * Persists user for registration.
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @return
	 */
	@RequestMapping(value = "/UserPersist", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response createUser(final HttpServletRequest request) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		return register.createUser(firstName, lastName, userName, email,
				password, request);
	}
	
	@RequestMapping(value = "/CreateProfile", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response createProfile(final HttpServletRequest request){
		String userId = request.getParameter("userId");
		String displayName = request.getParameter("displayName");
		String userBio = request.getParameter("userBio");
		String birthDate = request.getParameter("birthDate");
		String top5Movies = request.getParameter("top5Movies");
		
		return userProfile.createProfile(userId, displayName, userBio, birthDate, top5Movies);
	}
	
	@RequestMapping(value = "/UpdateProfile", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response updateProfile(final HttpServletRequest request){
		String userId = request.getParameter("userId");
		String displayName = request.getParameter("displayName");
		String userBio = request.getParameter("userBio");
		String birthDate = request.getParameter("birthDate");
		String top5Movies = request.getParameter("top5Movies");
		
		return userProfile.updateProfile(userId, displayName, userBio, birthDate, top5Movies);
	}
	/**
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "/UserProfile")
	public String userProfile(){
		
		return "profile.jsp";
	}

	/**
	 * 
	 * returns to Welcome page
	 */

	@RequestMapping(value = "/Welcome")
	public String displayWelcomePage() {

		return "welcome.jsp";
	}

	/**
	 * 
	 * returns login page
	 */
	@RequestMapping(value = "/Login")
	public String loginPage(final HttpServletRequest request) {

		return "login.jsp";
	}

	/**
	 * 
	 * returns registration page
	 */
	@RequestMapping(value = "/Register")
	public String registerPage(final HttpServletRequest request) {

		return "registration.jsp";
	}
	@RequestMapping(value = "/Waiting")
	public String waiting(final HttpServletRequest request) {

		return "waiting.jsp";
	}

	/**
	 * returns to LandingPage
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/LandingPage")
	public String mainPage(final HttpServletRequest request) {

		return "landingPage.jsp";

	}

	@RequestMapping(value = "/PostPage")
	public String postPage(final HttpServletRequest request) {
		return "postPage.jsp";
	}

	/**
	 * mapping for ViewPublicEntries.jsp page.
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ViewPublicEntries")
	public String publicEntries(final HttpServletRequest request) {
		return "viewPublicEntries.jsp";
	}

	/**
	 * invalidates session and returns user to Welcome page.
	 * 
	 * @param request
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/About")
	public String about(final HttpServletRequest request) {
		return "about.jsp";
	}

	@RequestMapping(value = "/Inbox")
	public String inbox(final HttpServletRequest request) {
		return "inbox.jsp";
	}

	@RequestMapping(value = "/SendMessagePage")
	public String sendMessagePage(final HttpServletRequest request) {
		return "sendMessage.jsp";
	}

	@RequestMapping(value = "/ReadMessage")
	public String readMessage(final HttpServletRequest request) {
		return "readMessage.jsp";
	}

	@RequestMapping(value = "/Logout", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response logout(final HttpServletRequest request) {
		Response response = responseFactory.getResponse();
		response = new Response();
		try {
			request.getSession().invalidate();
		} catch (Exception e) {
			response.setError(INVALIDATE_ERROR);
		}
		response.setSuccess("Success");
		return response;
	}


	@RequestMapping(value = "/ViewMessage")
	public String viewMessage(HttpServletRequest request) {

		return "viewMessage.jsp";
	}
	
	/**
	 * testing purposes
	 * 
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Gets a list of all users from the database.
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/GetAllUsers", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public List<User> allUsers(final HttpServletRequest request) {
		return userDao.getAllUsers();
	}

	/**
	 * @return the register
	 */
	public Registration getRegister() {
		return register;
	}

	/**
	 * @param register
	 *            the register to set
	 */
	public void setRegister(Registration register) {
		this.register = register;
	}

}
