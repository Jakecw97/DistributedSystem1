package ie.gmit.ds;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserApiServiceResource {
    private HashMap<Integer, User> usersHashMap = new HashMap<Integer, User>();//HashMap
    private Scanner console;

    public UserApiServiceResource(){
        User testUser = new User(01, "Who", "Who@askJeeves.com", "12A");
        User testUser1 = new User(02, "What", "What@askJeeves.com", "34B");
        User testUser2 = new User(03, "When", "When@askJeeves.com", "56C");
        User testUser3 = new User(04, "Where", "Where@askJeeves.com", "78D");
        usersHashMap.put(testUser.getUserId(), testUser);
        usersHashMap.put(testUser1.getUserId(), testUser1);
        usersHashMap.put(testUser2.getUserId(), testUser2);
        usersHashMap.put(testUser3.getUserId(), testUser3);
    }//UserApiServiceResource


    @GET
    public Collection<User> getUsers() {
        return usersHashMap.values();
    }//GetUsers

    @GET
    @Path("{userId}")
    public User getUserById(@PathParam("userId") int userId) {
        return usersHashMap.get(userId);
    }//getUserById


    @Path("/signUp")
    @POST
    public Response createUser(User user) throws URISyntaxException {

        User u = usersHashMap.get(user.getUserId());
        if (u == null) {
             u = new User(06, "dd", "www@ww.com", "132s");
        }
        Response build = Response.status(Status.CREATED).type(MediaType.TEXT_PLAIN).entity("User" + u.getUserName() + "Added to Database.").build();
        return build;
    }//signUp(Doesn't work)

    @DELETE
    @Path("delete/{userId}")
    public Response deleteUser(@PathParam("userId") Integer userId) {
        User user = usersHashMap.get(userId);
        //If user doest not exist
        if (user == null)
            return Response.status(Status.NOT_FOUND).build();
        //Otherwise delete user by userId
        else
            usersHashMap.remove(userId);
        return Response.status(Status.NO_CONTENT).build();
    }//delete
}
