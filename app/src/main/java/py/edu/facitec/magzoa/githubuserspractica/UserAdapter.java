package py.edu.facitec.magzoa.githubuserspractica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private List<User> users;


    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }



    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int position) {
        return this.users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.users.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;

       if(view==null){
                                            //,parent,false
  view= LayoutInflater.from(context).inflate(R.layout.item_user,null);


       }

       User user=(User) getItem(position);

        TextView loginTextView=view.findViewById(R.id.textViewLogin);

        ImageView avatarImageView=view.findViewById(R.id.imageViewAvatar);

        loginTextView.setText(user.getLogin());

        Picasso.get().load(user.getAvatar_url()).into(avatarImageView);

        return  view;
    }
}
