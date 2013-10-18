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
	private MovieLists movieList;
	
	@Autowired
	private MovieEntries movieEntries;
	
	@RequestMapping(value = "/CreateList", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response createList(final HttpServletRequest request) {

		String userId = request.getParameter("userId");
		String listName = request.getParameter("listName");
	

		return movieList.createList(userId, listName, request);
	}
	
	
	@RequestMapping(value = "/AddMovie", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Response addMovieEntry(final HttpServletRequest request) {

		String listId = request.getParameter("listId");
		String movieName = request.getParameter("movieName");
		String imdbId = request.getParameter("imdbId");
	
		return movieEntries.addMovieEntry(listId, movieName, imdbId, request);
	}
	
}
