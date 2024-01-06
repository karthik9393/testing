package com.codewithkarthik.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.codewithkarthik.entity.User;
import com.codewithkarthik.exception.InputMissingException;
import com.codewithkarthik.exception.InvalidAddressException;
import com.codewithkarthik.exception.NoRecordFoundException;
import com.codewithkarthik.exception.RecordNotFoundException;
import com.codewithkarthik.exception.UserNotFoundException;
import com.codewithkarthik.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public List<User> getAll() {
		List<User> userList = repo.findAll();
		if(userList.isEmpty()) {
			throw new NoRecordFoundException("007","No records found!");
		}
		return userList;

	}

	public User getById(Long id) {
		Optional<User> findById = repo.findById((Long)id);
		if(!findById.isPresent()) {
			throw new RecordNotFoundException("008", "User record is not found!");
		}
		return findById.get();
		
	}

	// implementation of custom query
	public User getByName(String name) {
		
		
		if(name.length()==0 || name.isEmpty()) {
			throw new InputMissingException("703", "Input Details Missing!");
		}
		User byName = repo.getByName(name);
		return byName;
	}

	public User addUser(User user) {
		
		if(user.getName().length()==0 || user.getName().isEmpty()) {
			throw new InputMissingException("999", "Cannot be saved due to no input name");
			
		}
		if(!user.getAddress().contains(",")) {
			throw new InvalidAddressException("704", "Address is not valid due to ','");
		}
		User save = repo.save(user);
		return save;
	}

	public void deleteUserbyId(Long id) {
		if(!repo.findById(id).isPresent()) {
			
			throw new RecordNotFoundException("705","User record not found for Id");
			
		}
		repo.deleteById(id);
	}

	public User updateUser(Long userId, User updatedUser) {
		Optional<User> optionalUser = repo.findById(userId);
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setName(updatedUser.getName());
			existingUser.setPhone(updatedUser.getPhone());
			existingUser.setAddress(updatedUser.getAddress());
			return repo.save(existingUser);
		} else {
			throw new UserNotFoundException("7009","User not found with ID: " );
		}

	}

	public User updateUserByFields(Long id, Map<String, Object> fields) {
		Optional<User> OptionalUser = repo.findById(id);
		if (OptionalUser.isPresent()) {
			User existingUser = OptionalUser.get();
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(User.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingUser, value);
			});

			return repo.save(existingUser);
		}
		return null;

	}

}
