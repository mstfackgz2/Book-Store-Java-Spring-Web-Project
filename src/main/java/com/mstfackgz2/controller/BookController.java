package com.mstfackgz2.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.mstfackgz2.entity.Book;
import com.mstfackgz2.entity.MyBookList;
import com.mstfackgz2.service.BookService;
import com.mstfackgz2.service.MybookListService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	MybookListService mybookListService;
	
	 @GetMapping("/")
	    public String home() {
	        return "home";
	    }
	 
	 @GetMapping("/book_register")
	    public String bookRegister() {
	        return "bookRegister";
	    } 

	 @GetMapping("/available_books")
	    public ModelAndView getAllBooks() {
		 	List<Book> books = bookService.getAllBooks();
		 	ModelAndView maw = new ModelAndView();
		 	maw.setViewName("bookList");
		 	maw.addObject("book",books);
	        return maw; 
	    }
	 
	 @PostMapping("/save_book")
	 public String saveBook(@ModelAttribute Book book) {
	 	bookService.saveBook(book);
	 	return "redirect:/available_books";
	 }
	 
	 
	 @GetMapping("/my_books")
	 public String getMyBooks(Model model ) {
		 List<MyBookList> myBookList = mybookListService.getAllMyBooks();
		 model.addAttribute("book",myBookList);
	 	return "myBooks";
	 }
	 
	 @RequestMapping("/mylist/{id}")
	 public String getMyList(@PathVariable(name = "id") Integer id) {
		 Book book = bookService.getBookById(id);

		 MyBookList mybook = new MyBookList();
		 BeanUtils.copyProperties(book, mybook);
		 mybookListService.saveMyBooks(mybook);
		 
	 	return "redirect:/my_books";
	 }
	 
	 @RequestMapping("/editBook/{id}")
	 public String editBook(@PathVariable(name = "id") Integer id, Model model) {
		 Book book = bookService.getBookById(id);
		 model.addAttribute("book",book);
	 	return "bookEdit";
	 }
	 
	 @RequestMapping("/deleteBook/{id}")
	 public String deleteBook(@PathVariable(name = "id") Integer id, Model model) {
		bookService.deleteById(id);
	 	return "redirect:/available_books";
	 }
	 
	 
	 
}


