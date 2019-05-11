package pl.sda.kantor.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Users")
public class User {

    @Id
    public String username;
    public String password;
    public Boolean enabled;
}
