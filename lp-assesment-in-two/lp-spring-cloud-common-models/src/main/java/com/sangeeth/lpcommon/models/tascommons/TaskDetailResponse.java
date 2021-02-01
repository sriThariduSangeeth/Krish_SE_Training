package com.sangeeth.lpcommon.models.tascommons;

import com.sangeeth.lpcommon.models.project.Project;
import com.sangeeth.lpcommon.models.task.Task;

/**
 * @author dtsangeeth
 * @created 09 / 01 / 2021
 * @project lp-spring-cloud-common-models
 */
public class TaskDetailResponse implements ProjectInTaskResponse{

    private Task task;
    private Project project;

    public TaskDetailResponse(Task task, Project project) {
        this.task = task;
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
