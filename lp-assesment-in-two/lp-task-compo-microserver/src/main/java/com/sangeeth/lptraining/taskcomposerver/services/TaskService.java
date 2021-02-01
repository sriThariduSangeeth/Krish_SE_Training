package com.sangeeth.lptraining.taskcomposerver.services;


import com.virtusa.lpcommon.models.tascommons.ProjectInTaskResponse;
import com.virtusa.lpcommon.models.task.Task;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-task-compo-microserver
 */
@Service
public interface TaskService {

    Task saveTask(Task task) throws JpaSystemException;
    ProjectInTaskResponse fetchTaskById(int id , String type) throws JpaSystemException;
    List<Task> getAllTaskListByProjectId(int id) throws JpaSystemException;
}
