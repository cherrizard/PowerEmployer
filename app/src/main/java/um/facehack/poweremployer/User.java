package um.facehack.poweremployer;

/**
 * Created by calvinlow on 18/11/2017.
 */

public class User {

    protected Long id;
    protected String name;
    protected String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
