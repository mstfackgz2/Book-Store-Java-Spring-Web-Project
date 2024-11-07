package com.mstfackgz2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MyBooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBookList {

	@Id
	@Column(name = "book_id")
	private Integer id;
	private String name;
	private String author;
	private String price;
	
}
