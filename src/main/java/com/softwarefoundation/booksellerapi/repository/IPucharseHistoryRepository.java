package com.softwarefoundation.booksellerapi.repository;

import com.softwarefoundation.booksellerapi.model.PucharseHistory;
import com.softwarefoundation.booksellerapi.repository.projection.IPucharseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPucharseHistoryRepository extends JpaRepository<PucharseHistory, Long> {

    @Query("select b.title, p.price, p.pucharseTime from PucharseHistory p left join Book b on b.id = p.bookId where p.userId = :userId")
    List<IPucharseItem> findAllPucharseesOfUser(@Param("userId") Long userId);


}
