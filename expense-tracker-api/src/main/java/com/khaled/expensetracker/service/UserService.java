package com.khaled.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaled.expensetracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/*public UserDao registerUser(UserDao user) throws UserException {
		System.out.println("number 11111");

		String email = user.getEmail().toString();
		System.out.println("email" + "   " + email);
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if (email != null)
			email = email.toLowerCase();
		if (!pattern.matcher(email).matches())
			throw new UserException("Not Valid email Format");
		Integer count = userRepository.countByEmail(email);
		if (count > 0)
			throw new UserException("This email is already exists");
		System.out.println("hiiiiiiiiiiii");
		String hashedPassword =	BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
user.setPassword(hashedPassword);
		User theuser = userRepository.save(user);
		return theuser;

	}*/

	/*public UserDao validateUser(UserDao theUser) throws UserException {

		if (theUser.getEmail() != null)
			theUser.getEmail().toLowerCase();
		String hashedPassword = userRepository.findByEmail(theUser.getEmail()).get().getPassword();
		if(!BCrypt.checkpw(theUser.getPassword(),hashedPassword))
				throw new UserException("invalid email or password");
	
		return userRepository.findByEmailAndPassword(theUser.getEmail(),hashedPassword);

	}*/

}
