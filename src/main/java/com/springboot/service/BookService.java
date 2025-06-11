package com.springboot.service;

import com.springboot.domain.Book;

import java.util.List;

public interface BookService {
  List<Book> getAllBookList();

  Book getBookById(String bookId);

  List<Book> getBookListByCategory(String category);

  List<Book> getBookListByFilter(String category, String publisher);
}