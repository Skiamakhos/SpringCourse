package com.skiamakhos.spring6webapp.repositories;

import com.skiamakhos.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
