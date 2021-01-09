package com.virtusa.lpcommon.models.tascommons;

import com.virtusa.lpcommon.models.task.Task;

/**
 * @author dtsangeeth
 * @created 09 / 01 / 2021
 * @project lp-spring-cloud-common-models
 */
public class TaskSimpleResponse implements ProjectInTaskResponse{

    private Task task;

    public TaskSimpleResponse(Task task) {
        this.task = task;
    }
}
