package br.com.tivit.mvpsaude.service.implementation;

import br.com.tivit.mvpsaude.configuration.UserDetailsImpl;
import br.com.tivit.mvpsaude.model.User;
import br.com.tivit.mvpsaude.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User save(User user) {
    return userRepository.save(user);
  }

  public User findByUsername(String username) {
    return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = this.findByUsername(username);
    return UserDetailsImpl.build(user);
  }

}