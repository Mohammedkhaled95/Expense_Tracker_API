package com.khaled.expensetracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khaled.expensetracker.config.JwtTokenUtil;
import com.khaled.expensetracker.model.Category;
import com.khaled.expensetracker.model.UserDao;
import com.khaled.expensetracker.repository.CategoryRepository;
import com.khaled.expensetracker.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

	
	@Autowired
	private CategoryRepository categoryRepo;

	

	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@GetMapping("")
	public ResponseEntity<Map<String, Object>> getAllCategories(HttpServletRequest request) {
		// int userId = (Integer)request.getAttribute("userId");
		System.out.println("v*v*v*v*v*v*v*v*v*v* ");// +request.getAttribute("userId").toString());

		List<Category> allCats = categoryRepo.findAll();
		Map<String, Object> map = new HashMap();
		map.put("categories", allCats);
		map.put("Status", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
	
	

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getCategory(@PathVariable Integer id) {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();

		UserDao user = userRepo.findByUsername(username);

		
		Map<String, Object> map = new HashMap();

		Optional<Category> category = categoryRepo.findById(id);
		if (category.isPresent()) {
			map.put("Status", HttpStatus.OK);
			map.put("category", category);
		} else {
			map.put("Status", HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	
	
	
	
	@PostMapping()
	public ResponseEntity<Category> addCategory(@RequestBody Category theCategory) {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();

		UserDao user = userRepo.findByUsername(username);

		theCategory.setUser(user);
		Category category = categoryRepo.save(theCategory);

		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
		
		
		
	}

	
	
	
	
	/*
	 * add category after refactoring
	 * 
	 * @PostMapping()
	public ResponseEntity addCategory(@PathVariable Integer userId,@RequestBody Category theCategory) {
	
		
		User user =userRepo.findById(userId).orElse(null) ;
		
		
		if (user==null) 
			return new ResponseEntity("there is no user with given id "+userId, HttpStatus.CREATED);

			theCategory.setUser(user);
			Category category = categoryRepo.save(theCategory);
		
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}
	*/
	
	
	
	
	
	
	@PutMapping()
	public ResponseEntity<Map<String, Object>> updateCategory(@RequestBody Category category) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();

		UserDao user = userRepo.findByUsername(username);

		if (!categoryRepo.findById(category.getId()).isPresent()) {
			return new ResponseEntity("Requested Category Doesn't Exist", HttpStatus.OK);

		}
		System.out.println("user  "+user.getUsername());
		category.setUser(user);
		Category c = categoryRepo.save(category);
		Map<String, Object> map = new HashMap();
		map.put("updatedCategory", c);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}

	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCategory(@PathVariable String id) {
		
		
		Integer theId = Integer.parseInt(id);
		if (!categoryRepo.findById(theId).isPresent()) {
			return new ResponseEntity("This category doesn't exist",HttpStatus.OK);

		}
		categoryRepo.deleteById(theId);
		return new ResponseEntity("Deleted Succefully",HttpStatus.OK);
				}

}
