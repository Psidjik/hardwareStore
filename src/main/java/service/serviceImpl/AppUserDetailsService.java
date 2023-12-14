package service.serviceImpl;

//import com.example.projectwebautocenterbukin.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import repositories.ClientRepository;

import java.util.Collections;


public class AppUserDetailsService implements UserDetailsService {
    private ClientRepository clientRepository;

    public AppUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findByUsername(username)
                .map(u -> new org.springframework.security.core.userdetails.User(
                        u.getUsername(),
                        u.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + u.getRole().getRole().name()))
                )).orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
