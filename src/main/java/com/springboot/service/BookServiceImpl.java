package com.springboot.service;

import com.springboot.domain.Book;
import com.springboot.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  // 생성자가 하나뿐인 경우 @Autowired 생략 가능 (Spring 4.3 이상)
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> getAllBookList() {
    return bookRepository.getAllBookList();
  }

  @Override
  public Book getBookById(String bookId) {
    return bookRepository.getBookById(bookId);
  }

  @Override
  public List<Book> getBookListByCategory(String category) {
    return bookRepository.getBookListByCategory(category);
  }

  @Override
  public List<Book> getBookListByFilter(String category, String publisher) {
    return bookRepository.getBookListByFilter(category, publisher);
  }

  @Override
  public void setNewBook(Book book) {
    bookRepository.setNewBook(book);
  }
}