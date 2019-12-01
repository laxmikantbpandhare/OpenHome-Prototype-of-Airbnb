package com.database.databasedemo.repository;


import com.database.databasedemo.entity.Property;
import com.database.databasedemo.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ReservationRepo  extends JpaRepository<Reservations,Integer>, JpaSpecificationExecutor {

  //  List<Reservations> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime start_date, OffsetDateTime end_date);



    //@Query(value = "from Reservations t where yourDate BETWEEN :start_date AND :end_date")
//    @Query("SELECT Reservations FROM Reservations WHERE end_date >= ?1 AND   start_date <= ?2 ")
//    List<Reservations> getAllBetweenDates(OffsetDateTime start_date, OffsetDateTime end_date);


    @Query("SELECT a FROM reservations a WHERE a.guest_id = ?1")
    List<Reservations> findByGuestId(int guestId);


}

