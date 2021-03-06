package edu.vanderbilt.finsta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoApplication.class, args);
	}

	/**
	 * Step 1.
	 *
	 * Authentication has been added to this example app. You can login
	 * using one of the default accounts:
	 *
	 * admin / admin
	 * user / pass
	 *
	 * You can also add accounts like this:
	 *
	 * http://localhost:8080/user?login=jules&first=jules&pass=pass&email=foo@foo.com
	 *
	 * You can logout by going to:
	 *
	 * http://localhost:8080/api/logout
	 *
	 *
	 * Step 2.
	 *
	 * Look at how PhotoUrl has been modified. It has a number of Java
	 * annotations added to it. These annotations have been added so we
	 * can save PhotoUrl objects into a database.
	 *
	 * Create a new class called Comment that can be persisted to a database.
	 * You will need to have the @Entity annotation on the class and an "id"
	 * variable with the same type and annotations as the one in PhotoUrl.
	 *
	 * Add string member variables for "user" and "content" to the Comment
	 * class.
	 *
	 *
	 *
	 * Step 3.
	 *
	 * Repositories are how you save / query for objects from the database.
	 *
	 * Create a new CommentRepository interface that mirrors the structure of
	 * the PhotoUrlRepository. You will need to replace the references to
	 * PhotoUrl with Comment. You can omit the method declaration.
	 *
	 *
	 * Step 4.
	 *
	 * Create a new CommentController class. Make sure that your CommentController has the
	 * @RestController annotation on the class declaration.
	 *
	 *
	 * Step 5.
	 *
	 * Add a constructor to your CommentController that takes your CommentRepository as
	 * a parameter. The constructor should have the @Autowired annotation above it. You
	 * should also add a member variable named commentRepo of type CommentRepository to
	 * your controller class. Inside of the constructor, set this member variable to the
	 * CommentRepository instance passed into the constructor.
	 *
	 * Step 6.
	 *
	 * Add a method to your CommentController to add a comment
	 * when a request is sent to /comment/add. Your method should take parameters
	 * for the user and content. In this method, use the parameters to
	 * construct a new Comment and then save it to the database by calling:
	 *
	 * commentRepo.save( commentYouCreated );
     	 *
     	 * http://localhost:8080/comment/add?user=bob&content=hi
	 *
	 * Step 7.
	 *
	 * Add a method to your CommentController to list all comments saved
	 * to the database when a request is sent to /comments. Your method
	 * should take no parameters and simply return the list of Comments
	 * from the database:
	 *
	 * commentRepo.findAll()
     	 *
     	 * http://localhost:8080/comments
     	 *
     	 * [{"id":52,"user":"admin","content":"hello"},{"id":53,"user":"bob","content":"hi"}]
	 *
	 * Step 8.
	 *
	 * Rewrite your method to add comments to remove the string user parameter
	 * and replace it with a new user parameter of type java.security.Principal.
	 * Make sure that the user parmameter comes last in the arguments list.
	 *
	 * For example, if you previously had:
	 *
	 * public boolean addComment( String user, String content) ...
	 *
	 * You would rewrite it:
	 *
	 * public boolean addComment( String content, Principal user) ....
     	 *
	 * Instead of the string user parameter that was supplied to your Comment
     	 * in the previous version, use the value of calling the .getName() method
     	 * on the Principal object passed in:
     	 *
     	 * commentYouCreated.setUser(user.getName())
     	 *
     	 * This modification allows us to attach comments to the currently logged in
     	 * user. Before, anyone could claim to be any user. This modification allows
     	 * us to ensure that the Comment is attached to the currently logged in user
     	 * that is sending the request.
     	 *
	 * The Principal object will automatically be populated with an object
	 * representing the currently logged in user. Spring takes care of the
	 * authentication details and passes you the details of who is logged
	 * in and invoking the method.
     	 *
     	 * http://localhost:8080/comment/addToCurrentUser?content=hello
     	 *
	 **/

}
