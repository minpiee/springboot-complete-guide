package com.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private String bookId;        // 도서 ID
  private String name;          // 도서 제목
  private BigDecimal unitPrice; // 가격
  private String author;        // 저자
  private String description;   // 설명
  private String publisher;     // 출판사
  private String category;      // 분류
  private long unitsInStock;    // 재고수
  private String releaseDate;   // 출판일(년/월/일)
  private String condition;     // 상태(신규도서/중고도서/전자책)

}