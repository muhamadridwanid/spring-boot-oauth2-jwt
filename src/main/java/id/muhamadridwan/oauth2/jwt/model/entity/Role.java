package id.muhamadridwan.oauth2.jwt.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Role extends BaseID implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 6, max = 60)
    private String authority;

}
