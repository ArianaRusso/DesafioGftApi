package gft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gft.dtos.user.UserMapper;
import gft.dtos.user.UserQueryDTO;
import gft.dtos.user.UserRegistrationDTO;
import gft.entities.UserModel;
import gft.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserQueryDTO> saveUser (@RequestBody UserRegistrationDTO dto){
		
		try {
					
			UserModel user=  userService.saveUser(UserMapper.dtoToEntity(dto));
			
			return ResponseEntity.ok(UserMapper.entityToDto(user));

		}catch(Exception e) {
			System.out.println(dto.getRoleId());
			return ResponseEntity.notFound().build();
			
		}
		
		
		
		
	}
	
	@GetMapping
	public ResponseEntity<Page<UserQueryDTO>> listAllUser(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(userService.findAllUser(pageable).map(UserMapper::entityToDto));
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserQueryDTO> findUserById(@PathVariable Long id){
		UserModel user = userService.findUserById(id);
		return ResponseEntity.ok(UserMapper.entityToDto(user));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<UserQueryDTO> deleteUser (@PathVariable Long id) {
		
		try {
			userService.deleteUser(id);
			return ResponseEntity.ok().build();
			
		}catch(RuntimeException ex){
			return ResponseEntity.notFound().build();
			
		}

	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<UserQueryDTO> updateUser (@RequestBody UserRegistrationDTO dto, @PathVariable Long id) {
		
		try {
		
			UserModel user = userService.updateUser(UserMapper.dtoToEntity(dto),id);
			return ResponseEntity.ok(UserMapper.entityToDto(user));

		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}

	
	

}
