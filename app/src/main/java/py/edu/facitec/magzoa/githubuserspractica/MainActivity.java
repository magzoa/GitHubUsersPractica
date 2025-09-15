package py.edu.facitec.magzoa.githubuserspractica;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<User>> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        UserServicio servicio=restAdapter.create(UserServicio.class);


        servicio.getUsers(this);



    }

    @Override
    public void success(List<User> users, Response response) {

        Log.i("GITHUB", users.toString());

    }

    @Override
    public void failure(RetrofitError error) {
Log.e("GITHUB",error.getLocalizedMessage());
    }
}