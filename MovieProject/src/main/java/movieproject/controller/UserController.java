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
import movieproject.utilities.UserFactory;

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
	private UserFactory uFactory = new UserFactory();


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

	@RequestMapping(value = "/welcome")
	public String displayWelcomePage() {

		return "welcome";
	}

	/**
	 * 
	 * returns login page
	 */
	@RequestMapping(value = "/login")
	public String loginPage(final HttpServletRequest request) {

		return "login";
	}
	
	@RequestMapping(value = "/common")
	public String commonPage(final HttpServletRequest request) {

		return "common";
	}

	@RequestMapping(value = "/denied")
	public String deniedPage(final HttpServletRequest request) {

		return "denied";
	}
	
	@RequestMapping(value = "/main")
	public String mainPage(final HttpServletRequest request) {

		return "welcome";
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
	 * testing purposes
	 * 
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



}
