package com.demo.bustravel.repository;

import com.demo.bustravel.model.Town;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends CrudRepository<Town, String> {
}
