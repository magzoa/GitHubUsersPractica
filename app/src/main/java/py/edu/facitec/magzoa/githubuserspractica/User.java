package py.edu.facitec.magzoa.githubuserspractica;

import androidx.annotation.NonNull;

public class User {


    private int id;
    private String login;
    private String avatar_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @NonNull
    @Override
    public String toString() {
        return id +"\n"+
                login + "\n" +
                 avatar_url + "\n";
    }
}
