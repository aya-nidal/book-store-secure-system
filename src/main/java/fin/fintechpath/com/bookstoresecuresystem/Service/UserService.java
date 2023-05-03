package fin.fintechpath.com.bookstoresecuresystem.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService { }
//public class UserService implements UserDetailsService {
//    private UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        UserPrincipal userPrinciple = new UserPrincipal(user);
//        return userPrinciple;
//    }
//
//
//}
