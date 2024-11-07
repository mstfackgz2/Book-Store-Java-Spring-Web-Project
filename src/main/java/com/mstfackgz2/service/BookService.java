package com.mstfackgz2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstfackgz2.entity.Book;
import com.mstfackgz2.repository.BookRepositoy;

@Service
public class BookService {

	@Autowired
	BookRepositoy bookRepositoy;
	
	
	public void saveBook(Book book) {
		bookRepositoy.save(book);
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		books = bookRepositoy.findAll();
		return books; 
		}
	
	public Book getBookById(Integer id) {
		
		return bookRepositoy.findById(id).get();
	}
	
	public void deleteById(Integer id) {
		bookRepositoy.deleteById(id);
	}
	
}
