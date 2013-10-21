/**
 * 
 */
package movieproject.utilities;

import movieproject.entities.MovieEntry;

import org.springframework.stereotype.Component;

/**
 * @author hyoung
 *
 */
@Component
public class MovieEntryFactory {

	
	public MovieEntry getMovieEntry(){
		return new MovieEntry();
	}
}
