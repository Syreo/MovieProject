/**
 * 
 */
package movieproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	
	/**
	 * Setting entity manager
	 */
	public void setEM(EntityManager em) {
		this.em = em;
	}
}
