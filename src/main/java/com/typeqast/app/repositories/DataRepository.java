package com.typeqast.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.typeqast.app.pojos.Data;

public interface DataRepository extends CrudRepository<Data, Long> {

}
