/**
 * 
 */
package movieproject.helpers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movieproject.dao.UserDao;
import movieproject.entities.Profile;
import movieproject.response.Response;
import movieproject.utilities.ProfileFactory;
import movieproject.utilities.ResponseFactory;
import movieproject.utilities.UserFactory;

/**
 * @author hyoung
 *
 */
@Component
public class UserProfile {

	@Autowired
	private UserDao userDao;
	long parsedUserId;
	long parsedBirthDate;
	
	private static final String UPE001 = "Invalid ID or Birthdate";
	private static final String UPE002 = "Could not persist Profile";
	private static final String UPE003 = "Could not update profile";
	private static final String SUCCESS = "SUCCESS";
	ResponseFactory rFactory = new ResponseFactory();
	ProfileFactory pFactory = new ProfileFactory();
	UserFactory uFactory = new UserFactory();
	
	
	public Response createProfile(String userId, String displayName, String userBio, String birthDate, String top5Movies){
		Response response = rFactory.getResponse();
		Profile profile = pFactory.getProfile();
		
		try {
		parsedUserId = Long.parseLong(userId);
		parsedBirthDate = Long.parseLong(birthDate);
		}catch(Exception e){
			response.setError(UPE001);
		}
		
		profile.setUserId(parsedUserId);
		profile.setDisplayName(displayName);
		profile.setUserBio(userBio);
		profile.setBirthDate(parsedBirthDate);
		profile.setTop5Movies(top5Movies);
		try{
		userDao.persistProfile(profile);
		response.setSuccess(SUCCESS);
		}catch(Exception e){
			response.setError(UPE002);
		}
		
		return response;
	}
	
	public Response updateProfile(String userId, String displayName, String userBio, String birthDate, String top5Movies){
		Response response = rFactory.getResponse();
		Profile profile = pFactory.getProfile();
		
		try {
		parsedUserId = Long.parseLong(userId);
		parsedBirthDate = Long.parseLong(birthDate);
		}catch(Exception e){
			response.setError(UPE001);
			return response;
		}
		try {
		profile = userDao.findProfileByUserId(parsedUserId);
		}catch(Exception e){
			response.setError(UPE003);
			return response;
		}
		profile.setUserId(parsedUserId);
		profile.setDisplayName(displayName);
		profile.setUserBio(userBio);
		profile.setBirthDate(parsedBirthDate);
		profile.setTop5Movies(top5Movies);
		
		
		try{
		userDao.updateProfile(profile);
		response.setSuccess(SUCCESS);
		}catch(Exception e){
			response.setError(UPE002);
		}
		
		return response;
	}
}
