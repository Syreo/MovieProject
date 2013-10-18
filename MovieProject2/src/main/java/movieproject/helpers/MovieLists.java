/**
 * 
 */
package movieproject.helpers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movieproject.dao.MovieDao;
import movieproject.entities.MovieList;
import movieproject.response.Response;
import movieproject.utilities.MovieListFactory;
import movieproject.utilities.ResponseFactory;

/**
 * @author hyoung
 *
 */
@Component
public class MovieLists {

	@Autowired
	private MovieDao movieDao;
	private MovieLists movieList;
	private ResponseFactory rFactory = new ResponseFactory();
	private MovieListFactory mFactory = new MovieListFactory();
	
	private long parsedUserId;
	private static final String MLE001 = "Invalid User ID.";
	private static final String MLE002 = "Empty List Name or User Id";
	private static final String MLE003 = "Unable to persist movie list";
	
	
	/**
	 * Creates MovieList
	 * @param userId
	 * @param listName
	 * @param request
	 * @return
	 */
	public Response createList(String userId, String listName, HttpServletRequest request){
		Response response = rFactory.getResponse();
		MovieList mList = mFactory.getMovieList();
		System.out.println(userId);
		System.out.println(listName);
		if(userId != "" && listName != ""){
			try{
			parsedUserId = Long.parseLong(userId);
			}catch(Exception e){
				response.setError(MLE001);
				return response;
			}
			System.out.println("parsed"+ parsedUserId);
			mList.setUserId(parsedUserId);
			mList.setListName(listName);
			persistMovieList(mList);
			
		}else {
			response.setError(MLE002);
		}
		
		return response;
		
	}
	/**
	 * persists new MovieList to the database
	 * @param mList
	 * @return
	 */
	public Response persistMovieList(MovieList mList){
		Response response = rFactory.getResponse();
		
		try{
			response = movieDao.persistMovieList(mList);
			response.setSuccess("Success");
		}catch(Exception e){
			response.setError(MLE003);
			return response;
		}
		
		return response;
		
	}
	
}
