/**
 * 
 */
package movieproject.helpers;

import javax.servlet.http.HttpServletRequest;

import movieproject.dao.MovieDao;
import movieproject.entities.MovieEntry;
import movieproject.response.Response;
import movieproject.utilities.MovieEntryFactory;
import movieproject.utilities.ResponseFactory;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hyoung
 *
 */
@Component
public class MovieEntries {
	private static final String MEE001 = "Invalid list Id or IMDB Id";
	private long imdbID;
	private long movieListId;
	private ResponseFactory rFactory = new ResponseFactory();
	private MovieEntryFactory mFactory = new MovieEntryFactory();
	
	@Autowired
	private MovieDao movieDao;
	
	public Response addMovieEntry(String listId, String movieName, String imdbId, HttpServletRequest request){
		Response response = rFactory.getResponse();
		MovieEntry movieEntry = mFactory.getMovieEntry();
		
		DateTime dateAdded = new DateTime();
		
		try{
		imdbID = Long.parseLong(imdbId);
		movieListId = Long.parseLong(listId);
		}catch(Exception e){
			response.setError(MEE001);
			return response;
		}
		movieEntry.setDateAdded(dateAdded);
		movieEntry.setImdbId(imdbID);
		movieEntry.setListId(movieListId);
		movieEntry.setMovieName(movieName);
		
		try {
			response = movieDao.persistMovieEntry(movieEntry);
		}catch(Exception e){
			response.setError("Could not persist MovieEntry");
		}
		
		
		return response;
	}
	
}
