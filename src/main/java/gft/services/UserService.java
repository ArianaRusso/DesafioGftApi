package gft.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gft.entities.UserModel;
import gft.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel saveUser (UserModel user) {
		return userRepository.save(user);
	}
	
	public Page<UserModel> findAllUser(Pageable pageable){
		return userRepository.findAll(pageable);
		
	}
	
	public UserModel findUserById(Long id) {
		Optional<UserModel> optional = userRepository.findById(id);
		return optional.orElseThrow(()-> new EntityNotFoundException("User não encontrado"));
		
	}
	
	public UserModel findUserByUserName (String userName) {
		Optional<UserModel> optional = userRepository.findByUserName(userName);
		
		return optional.orElseThrow(()-> new EntityNotFoundException("User não encontrado"));
	}
	
	
	public void deleteUser (Long id) {
		UserModel user = this.findUserById(id);
		userRepository.delete(user);
		
	}
	
	public UserModel updateUser (UserModel user, Long id) {
		UserModel userOriginal = this.findUserById(id);
		user.setId(userOriginal.getId());
		return userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return new User(userModel.getUserName(), userModel.getPassword(), true, true, true, true,
				userModel.getAuthorities());

	}
	
	
	
	

}
