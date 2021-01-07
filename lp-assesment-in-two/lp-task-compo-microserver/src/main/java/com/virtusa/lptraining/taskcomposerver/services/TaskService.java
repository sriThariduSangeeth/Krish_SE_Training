package com.virtusa.lptraining.taskcomposerver.services;

import com.virtusa.lptraining.taskcomposerver.entity.Task;
import com.virtusa.lptraining.taskcomposerver.model.TaskProjectMapping;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-task-compo-microserver
 */
@Service
public interface TaskService {

    Task saveTask(Task task);
    TaskProjectMapping fetchTaskById(int id);
}
