/**
 * 
 */
package movieproject.helpers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import movieproject.dao.MovieDao;
import movieproject.entities.MovieEntry;
import movieproject.response.Response;
import movieproject.utilities.MovieEntryFactory;
import movieproject.utilities.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hyoung
 *
 */
@Component
public class MovieEntries {
	private static final String MEE001 = "Invalid list Id or IMDB Id";
	private static final String MEE002 = "Could not delete movie";
	private static final String SUCCESS = "Success";
	private long movieListId;
	private ResponseFactory rFactory = new ResponseFactory();
	private MovieEntryFactory mFactory = new MovieEntryFactory();
	
	@Autowired
	private MovieDao movieDao;
	
	/**
	 * adds a movie to a list
	 * @param listId
	 * @param movieName
	 * @param imdbId
	 * @param request
	 * @return
	 */
	public Response addMovieEntry(String listId, String movieName, String imdbId, HttpServletRequest request){
		Response response = rFactory.getResponse();
		MovieEntry movieEntry = mFactory.getMovieEntry();
		
		Date dateAdded = new Date();
		
		try{
		
		movieListId = Long.parseLong(listId);
		}catch(Exception e){
			response.setError(MEE001);
			return response;
		}
		movieEntry.setDateAdded(dateAdded);
		movieEntry.setImdbId(imdbId);
		movieEntry.setListId(movieListId);
		movieEntry.setMovieName(movieName);
		
		try {
			response = movieDao.persistMovieEntry(movieEntry);
			response.setResponse(movieEntry);
		}catch(Exception e){
			response.setError("Could not persist MovieEntry");
		}
		
		
		return response;
	}
	
	/**
	 * deletes a movie from a movie list
	 * @param listId
	 * @param entryId
	 * @return
	 */
	public Response deleteMovie(String entryId){
		Response response = rFactory.getResponse();
		long parsedEntryId = Long.parseLong(entryId);
		
		try {
			response = movieDao.deleteMovie(parsedEntryId);
			if(response.getResponse().toString().equals("1")){
			response.setSuccess(SUCCESS);
			}
		}catch(Exception e){
			response.setError(MEE002);
		}
		
		return response;
	}
	
	
}
