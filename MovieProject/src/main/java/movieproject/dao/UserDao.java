package movieproject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import movieproject.entities.Profile;
import movieproject.entities.User;
import movieproject.response.Response;
import movieproject.utilities.ProfileFactory;
import movieproject.utilities.ResponseFactory;
import movieproject.utilities.UserFactory;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * UserDao Class
 * @author hyoung
 *
 */
@Component
public class UserDao{

	private ResponseFactory responseFactory = new ResponseFactory();
	private ProfileFactory pFactory = new ProfileFactory();
	private UserFactory uFactory = new UserFactory();
	private static final String SUCCESS = "SUCCESS";
	@PersistenceContext(unitName = "MovieProjectPU")
	private EntityManager em;
	
	/**
	 * Setting entity manager
	 */
	public void setEM(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * 
	 * persists user to the database.
	 */
	@Transactional
	public void persist(User user) {
		em.persist(user);
	}

	/**
	 * 
	 * updates user in the database
	 */
	@Transactional
	public void update(User user) {
		em.merge(user);
	}
	
	@Transactional
	public void persistProfile(Profile profile){
	em.persist(profile);
		
	}
	
	@Transactional
	public void updateProfile(Profile profile){
		em.merge(profile);
	}
	
	
	@Transactional
	public User findByUserName(String userName) {
		/*
		 * queries DB for user matching query params
		 */
		Query query = em.createNamedQuery("findByUserName");
		query.setParameter("userName", userName);
		User temp = new User();
		try {
			temp = (User) query.getSingleResult();

		} catch (Exception e) {
			return null;
		}
		return temp;
	}
	
	/**
	 * find users by their user ids. 
	 * @param userId
	 * @return
	 */
	@Transactional
	public User findUserByUserId(int userId) {
		User temp = null;

		Query query = em.createNamedQuery("findByUserId");
		query.setParameter("userId", userId);

		try {
			temp = (User) query.getSingleResult();

		} catch (RuntimeException e) {

		}
		return temp;

	}
	
	@Transactional
	public Profile findProfileByUserId(long userId){
		
		Profile profile = pFactory.getProfile();
		Query query = em.createNamedQuery("findProfileByUserId");
		query.setParameter("userId", userId);
		
		profile = (Profile) query.getSingleResult();
		return profile;
	}
	
	/**
	 * Gets a list of all users in the database
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getAllUsers() {

		Query query = em.createNamedQuery("findAllUsers");
		return query.getResultList();

	}
	
	@Transactional
	public String getUserNameByUserId(int userId){
		Query query = em.createNamedQuery("");
		query.setParameter("userId", userId);
		
		return (String) query.getSingleResult();
	}

@Transactional
public User getUser(int userId){
	User user = uFactory.getUser();
	
//	Query query = em.
	return user;
}
	

	
}
