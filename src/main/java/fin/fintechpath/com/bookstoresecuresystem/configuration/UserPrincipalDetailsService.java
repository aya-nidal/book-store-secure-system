package fin.fintechpath.com.bookstoresecuresystem.configuration;

import fin.fintechpath.com.bookstoresecuresystem.model.User;
import fin.fintechpath.com.bookstoresecuresystem.model.UserPrincipal;
import fin.fintechpath.com.bookstoresecuresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}

