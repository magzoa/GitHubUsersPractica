package py.edu.facitec.magzoa.githubuserspractica;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<User>> {

    ProgressBar progressBar;
    ListView usersListView;
    TextView errorTextView;


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

        progressBar=findViewById(R.id.progressBar);
        usersListView=findViewById(R.id.listViewUsers);
        errorTextView=findViewById(R.id.textViewError);







        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        UserServicio servicio=restAdapter.create(UserServicio.class);


        servicio.getUsers(this);



    }

    @Override
    public void success(List<User> users, Response response) {

       // Log.i("GITHUB", users.toString());

        progressBar.setVisibility(View.GONE);

        usersListView.setVisibility(View.VISIBLE);



        //ArrayAdapter<String> adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,users);


        UserAdapter adapter=new UserAdapter(this,users);

        usersListView.setAdapter(adapter);



    }

    @Override
    public void failure(RetrofitError error) {
        //Log.e("GITHUB",error.getLocalizedMessage());
    progressBar.setVisibility(View.GONE);
    errorTextView.setVisibility(View.VISIBLE);
    errorTextView.setText(getString(R.string.error_msj)+"\n"+error.getLocalizedMessage());


    }
}