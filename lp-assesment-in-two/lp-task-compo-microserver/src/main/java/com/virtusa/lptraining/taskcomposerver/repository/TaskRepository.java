package com.virtusa.lptraining.taskcomposerver.repository;

import com.virtusa.lpcommon.models.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-task-compo-microserver
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task save(Task task);
    Task findTaskByTaskId(int id);
    List<Task> findTasksByProjectId(int id);
}
