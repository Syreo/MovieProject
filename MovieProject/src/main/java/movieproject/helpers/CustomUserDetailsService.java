/**
 * 
 */
package movieproject.helpers;

import movieproject.dao.UserDao;
import movieproject.entities.User;
import movieproject.utilities.UserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author hyoung
 *
 */
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	private UserFactory uFactory = new UserFactory();
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = uFactory.getUser();
		
		user = userDao.findByUserName(userName);
	
		
		return (UserDetails) user;
	}
	
}
