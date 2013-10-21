/**
 * 
 */
package movieproject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import movieproject.entities.MovieEntry;
import movieproject.entities.MovieList;
import movieproject.response.Response;
import movieproject.utilities.ResponseFactory;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hyoung
 *
 */
@Component
public class MovieDao {

	private ResponseFactory rFactory = new ResponseFactory();
	@PersistenceContext(unitName = "MovieProjectPU")
	private EntityManager em;
	/**
	 * persists movielist to the database
	 * @param mList
	 * @return
	 */
	@Transactional
	public Response persistMovieList(MovieList mList){
		Response response = rFactory.getResponse();
		
		em.persist(mList);
		
		return response;
	}
	
	@Transactional
	public Response persistMovieEntry(MovieEntry mEntry){
		Response response = rFactory.getResponse();
		try {
		em.persist(mEntry);
		response.setSuccess("Success");
		}catch(Exception e){
			response.setError("Could not persist Movie Entry.");
		}
		
		return response;
	}
	
	@Transactional
	public Response getMovieListById(long listId){
		Response response = rFactory.getResponse();
		List<String>movieIdList = new ArrayList<String>();
		
		Query query = em.createNamedQuery("getMovieListById");
		query.setParameter("listId", listId);
		
		movieIdList = query.getResultList();
		
		response.setResponse(movieIdList);
		
		return response;
	}
	
	@Transactional
	public Response getAllLists(long userId){
		Response response = rFactory.getResponse();
		List<String>movieList = new ArrayList<String>();
		
		Query query =  em.createNamedQuery("getAllLists");
		query.setParameter("userId", userId);
		
		movieList = query.getResultList();
		
		response.setResponse(movieList);
		
		
		return response;
	}
	
	/**
	 * Setting entity manager
	 */
	public void setEM(EntityManager em) {
		this.em = em;
	}
}
