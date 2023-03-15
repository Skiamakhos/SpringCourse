package com.skiamakhos.spring6webapp.services;

import com.skiamakhos.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();

}
