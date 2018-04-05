package com.senior.sample.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.sample.domain.Book;
import com.senior.sample.domain.ItemDocument;
import com.senior.sample.repository.BookRepository;
import com.senior.sample.repository.ItemDocumentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elasticsearch")
public class ElasticResource {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	private ItemDocumentRepository itemDocumentRepository;

	@GetMapping("/springdata/book/{id}")
	public Book getBookById(@PathVariable String id) {

		List<Book> bookEntities = bookRepository.getByMessage("mysql从删库到跑路");
		for (Book bookEntity : bookEntities) {
			System.out.println(bookEntity);
		}
		Optional<Book> opt = bookRepository.findById("1");
		System.out.println(opt.orElseGet(null));
		Book bookEntity = opt.get();
		System.out.println(bookEntity);
		return bookEntity;
	}

	@PostMapping("/item")
	public ResponseEntity<String> createItem(@RequestBody ItemDocument document) {
		itemDocumentRepository.save(document);
		return new ResponseEntity<String>(document.toString(), HttpStatus.OK);
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<String> getItem(@PathVariable("id") String id) {
		ItemDocument com = itemDocumentRepository.findById(id).get();
		return new ResponseEntity<String>(com.toString(), HttpStatus.OK);
	}

}