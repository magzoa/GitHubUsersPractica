package py.edu.facitec.magzoa.githubuserspractica;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface UserServicio {

    @GET("/users")
    public void getUsers(Callback<List<User>> callback);

}
