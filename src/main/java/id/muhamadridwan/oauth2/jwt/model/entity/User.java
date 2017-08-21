package id.muhamadridwan.oauth2.jwt.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class User extends BaseID implements UserDetails {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 4, max = 24)
    private String username;

    @NotNull
    private String password;

    @Email
    @NotNull
    private String email;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean credentialsNonExpired;

    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> authorities;

}
