package com.mstfackgz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mstfackgz2.entity.MyBookList;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBookList, Integer> {

}
