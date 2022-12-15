package com.example.nest_leave_app.dao;

import com.example.nest_leave_app.model.VisitorLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VisitorLogDao extends CrudRepository<VisitorLog,Integer> {
    @Modifying
    @Transactional
    @Query(value ="UPDATE `logs_visitor` SET `exit_time`=:exitTime WHERE `id`=:visitorId" ,nativeQuery = true)
    void updateExitLogVisitor(@Param("visitorId") Integer visitorId, @Param("exitTime") String exitTime);
}
