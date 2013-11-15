/**
 * 
 */
package movieproject.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	@Autowired
	private ResponseFactory rFactory;
	@Autowired
	private MovieListFactory mFactory;
	
	
	private MovieLists movieList;
	 
	private long parsedUserId;
	private long parsedListId;
	private static final String MLE001 = "Invalid User ID.";
	private static final String MLE002 = "Empty List Name or User Id";
	private static final String MLE003 = "Unable to persist movie list";
	private static final String MLE004 = "Unable to retrieve contents of list";
	private static final String MLE005 = "Unable to retriever movie lists";
	private static final String MLE006 = "Unable to delete list";
	private static final String MLE007 = "Invalid List Id";
	private static final String SUCCESS = "Success";
	
	
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
		
			try{
			parsedUserId = Long.parseLong(userId);
			}catch(Exception e){
				response.setError(MLE001);
				return response;
			}
			try{
			mList.setUserId(parsedUserId);
			mList.setListName(listName);
			persistMovieList(mList);
			response.setSuccess(SUCCESS);
			response.setResponse(mList);
			
			}catch(Exception e){
		
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
	/**
	 * retrieves a list of movies by list id
	 * 
	 * @param listId
	 * @param request
	 * @return
	 */
	public Response retrieveMovieList(String listId, HttpServletRequest request){
		Response response = rFactory.getResponse();
		long parsedListId = Long.parseLong(listId);
		
		try{
		response = movieDao.getMovieListById(parsedListId);
		response.setSuccess(SUCCESS);
		}catch(Exception e ){
			response.setError(MLE004);
		}
		
		return response;
	}
	
	/**
	 * Gets all movie lists for a user
	 * @param userId
	 * @return
	 */
	
	public Response getAllLists(String userId){
		Response response = rFactory.getResponse();
		
		long parsedUserId = Long.parseLong(userId);
	
		try{
			response = movieDao.getAllLists(parsedUserId);
			response.setSuccess(SUCCESS);
		}catch(Exception e){
			response.setError(MLE005);
		}
		
		return response;
	}
	
	
	/**
	 * Gets a random movie from a movie list
	 * @param listId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Response getRandomMovie(String listId){
		Response response = rFactory.getResponse();
		long parsedListId = Long.parseLong(listId);
		response = movieDao.getMovieListById(parsedListId);
		Random random = new Random();
		List<String>movieList = new ArrayList<String>();
		
		movieList = (List<String>) response.getResponse();
		
		int movieListMax = movieList.size() - 1;
		
		int randomMovie = random.nextInt(movieListMax + 1);
		
		response.setResponse(movieList.get(randomMovie));
		return response;
	}
	
	public Response deleteList(String listId){
		Response response = rFactory.getResponse();
		
		
		try{
		parsedListId = Long.parseLong(listId);
		}catch(Exception e){
			response.setError(MLE007);
		}
		try{
		response = movieDao.deleteList(parsedListId);
		if(response.getResponse().toString().equals("1")){
			response.setSuccess(SUCCESS);
		}
		}catch(Exception e){
			response.setError(MLE006);
		}
		return response;
	}
}
