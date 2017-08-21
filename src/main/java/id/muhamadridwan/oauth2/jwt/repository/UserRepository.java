package id.muhamadridwan.oauth2.jwt.repository;

import id.muhamadridwan.oauth2.jwt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findTopByUsername(String username);

    User findTopByEmail(String email);

}
