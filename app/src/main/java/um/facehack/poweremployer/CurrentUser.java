package um.facehack.poweremployer;

/**
 * Created by calvinlow on 18/11/2017.
 */

public class CurrentUser {
    private static final CurrentUser ourInstance = new CurrentUser();

    public static CurrentUser getInstance() {
        return ourInstance;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
