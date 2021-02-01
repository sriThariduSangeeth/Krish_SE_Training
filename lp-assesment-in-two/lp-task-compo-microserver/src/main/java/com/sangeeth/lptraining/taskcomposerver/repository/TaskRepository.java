package com.sangeeth.lptraining.taskcomposerver.repository;

import com.virtusa.lpcommon.models.task.Task;
import org.springframework.data.domain.Sort;
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
    List<Task> findTasksByTaskStartDateAndTaskStatus(long startDate , String status);
    List<Task> findTasksByTaskEndDateAndTaskStatus(long endDate , String status);
    List<Task> findTasksByTaskStartDate(long startDate);
    List<Task> findTasksByTaskEndDate(long endDate);
    List<Task> findTasksByTaskAssign(String assing);
    List<Task> findTasksByTaskStatus(String status);
    List<Task> findTasksByTaskAssignAndTaskStatus(String assing , String status);
    List<Task> findTaskByProjectIdAndTaskAssign(int proId , String assign);
    List<Task> findTaskByProjectIdAndTaskAssignAndTaskStatus(int proId , String assign , String status);

}

