package com.typeqast.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.typeqast.app.pojos.MeterReadingData;

public interface MeterReadingRepository extends CrudRepository<MeterReadingData, Long> {

}
