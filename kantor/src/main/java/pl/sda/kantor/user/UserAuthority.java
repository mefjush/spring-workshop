package pl.sda.kantor.user;

import javax.persistence.*;

@Entity(name = "authorities")
public class UserAuthority {

    @Id
    public String username;
    public String authority;
}
