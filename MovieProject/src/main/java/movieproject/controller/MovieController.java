/**
 * 
 */
package movieproject.controller;

import javax.servlet.http.HttpServletRequest;

import movieproject.helpers.MovieEntries;
import movieproject.helpers.MovieLists;
import movieproject.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hyoung
 *
 */
@Controller
public class MovieController {

	@Autowired
	private MovieLists movieLists;
	
	@Autowired
	private MovieEntries movieEntries;
	
	
	
	
	/**
	 * Creates movie list
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/CreateList", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response createList(final HttpServletRequest request) {

		String userId = request.getParameter("userId");
		String listName = request.getParameter("listName");
	

		return movieLists.createList(userId, listName, request);
	}
	/**
	 * Adds a movie to a list
	 * @param request
	 * @return
	 */
	
	@RequestMapping(value = "/AddMovie", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response addMovieEntry(final HttpServletRequest request) {

		String listId = request.getParameter("listId");
		String movieName = request.getParameter("movieName");
		String imdbId = request.getParameter("imdbId");
	
		return movieEntries.addMovieEntry(listId, movieName, imdbId, request);
	}
	
	/**
	 * Retrieves a movie list by id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/RetrieveMovieList", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Response retrieveMovie(final HttpServletRequest request){
		
		String listId = request.getParameter("listId");
		return movieLists.retrieveMovieList(listId, request);
	}
	/**
	 * retrieves all lists for a user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/RetrieveAllLists", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Response getAllLists(final HttpServletRequest request){
		
		String userId = request.getParameter("userId");
		return movieLists.getAllLists(userId);
	}
	/**
	 * gets a random movie from a list
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/GetRandomMovie", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Response getRandomMovie(HttpServletRequest request){
		String listId = request.getParameter("listId");
		
		return movieLists.getRandomMovie(listId);
	}
	/**
	 * delets a movie from a movie list
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/DeleteMovie", produces = "application/json", method = RequestMethod.DELETE)
	@ResponseBody
	public Response deleteMovieFromList(HttpServletRequest request){
		
		String entryId = request.getParameter("entryId");
		
		return movieEntries.deleteMovie(entryId);
		
	}
	
	@RequestMapping(value = "/DeleteList", produces = "application/json", method = RequestMethod.DELETE)
	@ResponseBody
	public Response deleteMovieList(HttpServletRequest request){
		
		String listId = request.getParameter("listId");
		
		return movieLists.deleteList(listId);
	}
}
