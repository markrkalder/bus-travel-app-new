package com.demo.bustravel.repository;

import com.demo.bustravel.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
