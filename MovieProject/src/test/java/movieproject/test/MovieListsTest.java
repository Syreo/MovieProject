/**
 * 
 */
package movieproject.test;

import javax.persistence.EntityManager;

import movieproject.dao.MovieDao;
import movieproject.dao.UserDao;
import movieproject.entities.MovieList;
import movieproject.helpers.MovieLists;
import movieproject.response.Response;
import movieproject.utilities.MovieListFactory;
import movieproject.utilities.ResponseFactory;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author hyoung
 *
 */
public class MovieListsTest {
	MovieDao mDao;
	UserDao userDao;
	ResponseFactory rFactory;
	MovieListFactory mFactory;
	MovieList mList;
	Response response;
	EntityManager em;
	MovieLists movieLists;
	@Before
	public void setUp(){
		
		userDao = mock(UserDao.class);
		rFactory = mock(ResponseFactory.class);
		mFactory = mock(MovieListFactory.class);
		//mList = mock(MovieList.class);
		em = mock(EntityManager.class);
		mDao = mock(MovieDao.class);
		response = mock(Response.class);
		movieLists = mock(MovieLists.class);
	}
	
	@Test
	public void createListTest(){
		mList = mFactory.getMovieList();
		response = rFactory.getResponse();
		mList.setListId(1);
		mList.setUserId(1);
		mList.setListName("Test");
		when(mDao.persistMovieList(mList)).thenReturn(response);
		//assertEquals(response.getSuccess(), "SUCCESS");
	}
}
