package com.zch.tiny.repository;

import com.zch.tiny.model.TaskSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskScheduleRepository extends JpaRepository<TaskSchedule, Long> {
}
