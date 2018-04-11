package com.senior.sample.web.rest;

import java.util.List;
import java.util.Optional;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/elasticsearch")
@Api("ElasticSearch 相关 api")
public class ElasticResource {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	private ItemDocumentRepository itemDocumentRepository;

	@ApiOperation(value = "根据id查询学生的信息", notes = "查询数据库中某个学生的信息")
	@ApiImplicitParam(name = "id", value = "学生id", paramType = "path", required = true, dataType = "String")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户id", dataType = "String", paramType = "query", example = "1112") })
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"), @ApiResponse(code = 404, message = "请求路径没有找到") })
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