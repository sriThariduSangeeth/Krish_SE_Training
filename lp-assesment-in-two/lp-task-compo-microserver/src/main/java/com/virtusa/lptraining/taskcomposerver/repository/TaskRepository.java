package com.virtusa.lptraining.taskcomposerver.repository;

import com.virtusa.lptraining.taskcomposerver.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-task-compo-microserver
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task save(Task task);
    Task findTaskByTaskId(int id);
}
