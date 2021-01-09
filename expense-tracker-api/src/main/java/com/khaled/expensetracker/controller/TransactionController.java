package com.khaled.expensetracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khaled.expensetracker.exception.UserException;
import com.khaled.expensetracker.model.Category;
import com.khaled.expensetracker.model.Transaction;
import com.khaled.expensetracker.model.UserDao;
import com.khaled.expensetracker.repository.CategoryRepository;
import com.khaled.expensetracker.repository.TransactionRepository;
import com.khaled.expensetracker.repository.UserRepository;

@RestController
@RequestMapping("/api/categories/{categoryId}/transactions")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping("")
	public ResponseEntity<Map<String, Object>> getallTransactions() {
		Map<String, Object> map = new HashMap();

		if (transactionRepo.findAll().size() == 0) {

			map.put("transactions", "no transactions found");
			return new ResponseEntity(map, HttpStatus.NOT_FOUND);
		}

		List<Transaction> t = transactionRepo.findAll();

		map.put("transactions", t);
		return new ResponseEntity(map, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getTransaction(@PathVariable Integer id) {
		Map<String, Object> map = new HashMap();

		if (!transactionRepo.findById(id).isPresent()) {

			map.put("Status", "notFound");
			return new ResponseEntity(map, HttpStatus.NOT_FOUND);
		}
		Optional<Transaction> t = transactionRepo.findById(id);

		map.put("transaction", t);
		return new ResponseEntity(map, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Transaction> addTransaction(@PathVariable Integer categoryId,
			@RequestBody Transaction transaction) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		UserDao user = userRepo.findByUsername(username);

		Category cat = categoryRepo.findById(categoryId).orElseThrow(() -> new UserException("Category Not Found"));

		transaction.setUserId(user.getId());

		transaction.setCategory(cat);
		Transaction t = transactionRepo.save(transaction);

		return new ResponseEntity<Transaction>(t, HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer categoryId,
			@RequestBody Transaction transaction) {
		// todo: set id of user (get it from httpRequest)

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		UserDao user = userRepo.findByUsername(username);

		if (!categoryRepo.findById(categoryId).isPresent()) {
			return new ResponseEntity("This CAtegory is not found!", HttpStatus.NOT_FOUND);

		}
		if (!transactionRepo.findById(transaction.getId()).isPresent()) {
			return new ResponseEntity("This transaction is not found!", HttpStatus.NOT_FOUND);

		}
		transaction.setUserId(user.getId());
		transaction.setCategory(categoryRepo.findById(categoryId).get());
		Transaction t = transactionRepo.save(transaction);

		return new ResponseEntity<Transaction>(t, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Transaction> deleteTransaction(@PathVariable Integer id) {
		// todo: set id of user (get it from httpRequest)
//future work : you should check for category id sent before delete
		if (!transactionRepo.findById(id).isPresent()) {
			return new ResponseEntity("This transaction is not found!", HttpStatus.NOT_FOUND);

		}
		transactionRepo.deleteById(id);

		return new ResponseEntity("Deleted succefully ", HttpStatus.CREATED);
	}

}
