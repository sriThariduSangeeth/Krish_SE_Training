package com.sangeeth.lpcommon.models.procommons;

import com.sangeeth.lpcommon.models.project.Project;
import com.sangeeth.lpcommon.models.task.Task;

import java.util.List;

/**
 * @author dtsangeeth
 * @created 09 / 01 / 2021
 * @project lp-spring-cloud-common-models
 */
public class ProjectDetailResponse implements TaskInProjectResponse{

    private Project project;
    private List<Task> tasks;

    public ProjectDetailResponse(Project project, List<Task> tasks) {
        this.project = project;
        this.tasks = tasks;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }



}
