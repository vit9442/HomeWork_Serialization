import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String nickname;
    private String password;
    private Date registrationDate;

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        User user = (User) o;
        return (user.nickname.equals(this.nickname) && user.password.equals(this.password));
    }

    public String getNickname() {
        return nickname;
    }




}