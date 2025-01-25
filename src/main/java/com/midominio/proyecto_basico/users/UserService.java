package com.midominio.proyecto_basico.users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public Optional<User> getUserById(UUID id) {
	        return userRepository.findById(id);
	    }

	    public User createUser(UserDTO userDTO) {
	        User user = new User();
	        user.setName(userDTO.getName());
	        user.setEmail(userDTO.getEmail());
	        return userRepository.save(user);
	    }

	    public User updateUser(UUID id, UserDTO userDTO) {
	        return userRepository.findById(id)
	                .map(existingUser -> {
	                    existingUser.setName(userDTO.getName());
	                    existingUser.setEmail(userDTO.getEmail());
	                    return userRepository.save(existingUser);
	                })
	                .orElse(null);
	    }

	    public boolean deleteUser(UUID id) {
	        if (userRepository.existsById(id)) {
	            userRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}