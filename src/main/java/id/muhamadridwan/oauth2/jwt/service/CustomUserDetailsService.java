package id.muhamadridwan.oauth2.jwt.service;

import id.muhamadridwan.oauth2.jwt.model.entity.User;
import id.muhamadridwan.oauth2.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public UserDetails loadUserByUsername(String input) {
        User user = null;

        if (input.contains("@")) {
            user = userRepository.findTopByEmail(input);
        } else {
            user = userRepository.findTopByUsername(input);
        }

        if (user == null) {
            throw new UsernameNotFoundException("Incorrect username, password or admin id.");
        }

        detailsChecker.check(user);

        return user;
    }
}
