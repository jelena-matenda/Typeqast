package com.typeqast.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.typeqast.app.pojos.ProfileData;


@Repository
public interface ProfileRepository extends CrudRepository<ProfileData, Long> {

}
