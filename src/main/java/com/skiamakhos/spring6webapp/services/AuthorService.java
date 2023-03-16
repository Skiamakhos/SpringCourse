package com.skiamakhos.spring6webapp.services;


import com.skiamakhos.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
