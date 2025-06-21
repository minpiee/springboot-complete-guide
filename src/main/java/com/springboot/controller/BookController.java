package com.springboot.controller;

import com.springboot.domain.Book;
import com.springboot.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  // 생성자가 하나뿐인 경우 @Autowired 생략 가능 (Spring 4.3 이상)
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ModelAndView requestAllBooks() {
    ModelAndView mav = new ModelAndView();

    List<Book> bookList = bookService.getAllBookList();

    mav.addObject("categories", List.of("IT 전문서", "IT 교육교재"));
    mav.addObject("publishers", List.of("길벗", "한빛출판사"));
    mav.addObject("bookList", bookList);
    mav.setViewName("books");
    return mav;
  }

  @GetMapping("/book")
  public String requestBookById(@RequestParam("id") String bookId, Model model) {
    Book book = bookService.getBookById(bookId);
    model.addAttribute("book", book);
    return "book";
  }

  @GetMapping("/search")
  public String requestBookByFilter(@RequestParam(value = "category", required = false) String category,
                                    @RequestParam(value = "publisher", required = false) String publisher,
                                    Model model) {
    List<Book> bookList = bookService.getBookListByFilter(category, publisher);

    model.addAttribute("bookList", bookList);
    model.addAttribute("categories", List.of("IT 전문서", "IT 교육교재"));
    model.addAttribute("publishers", List.of("길벗", "한빛출판사"));
    model.addAttribute("selectedCategory", category);
    model.addAttribute("selectedPublisher", publisher);

    return "books";
  }

  @GetMapping("/add")
  public String requestAddBook() {
    return "addBook";
  }

  @PostMapping("/add")
  public String submitAddNewBook(@ModelAttribute Book book) {
    bookService.setNewBook(book);
    return "redirect:/books";
  }
}