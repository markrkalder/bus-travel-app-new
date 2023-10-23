package com.demo.bustravel.repository;

import com.demo.bustravel.model.ScheduleItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleItemRepository extends CrudRepository<ScheduleItem, String> {
}
