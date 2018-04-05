package com.senior.sample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.senior.sample.domain.Book;

public interface BookRepository extends CrudRepository<Book, String> {

	public List<Book> getByMessage(String key);
}