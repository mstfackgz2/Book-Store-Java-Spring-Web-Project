package com.mstfackgz2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstfackgz2.entity.MyBookList;
import com.mstfackgz2.repository.MyBooksRepository;

@Service
public class MybookListService {
	
	@Autowired
	private MyBooksRepository myBooksRepository;
	
	
	public void saveMyBooks(MyBookList book) {
		myBooksRepository.save(book);
		
	}
	
	public List<MyBookList> getAllMyBooks(){
		return myBooksRepository.findAll();
	}
	
	public void deleteById(Integer id) {
		myBooksRepository.deleteById(id);
	}
	
}
