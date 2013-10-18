/**
 * 
 */
package movieproject.utilities;

import movieproject.entities.MovieList;

import org.springframework.stereotype.Component;

/**
 * @author hyoung
 *
 */
@Component
public class MovieListFactory {

	
	public MovieList getMovieList(){
		return new MovieList();
	}
	
}
