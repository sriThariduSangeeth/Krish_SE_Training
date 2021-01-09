package com.virtusa.lpcommon.models.task;

import javax.persistence.*;

/**
 * @author dtsangeeth
 * @created 09 / 01 / 2021
 * @project lp-spring-cloud-common-models
 */
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    private int projectId;
    private String taskName;
    private String taskDiscription;
    private Long taskStartDate;
    private Long taskEndDate;
    private String taskPriority;
    private String taskStatus;
    private String taskAssign;

    public Task (int taskId, int projectId, String taskName, String taskDiscription, Long taskStartDate, Long taskEndDate, String taskPriority, String taskStatus, String taskAssign) {
        this.taskId = taskId;
        this.projectId = projectId;
        this.taskName = taskName;
        this.taskDiscription = taskDiscription;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.taskAssign = taskAssign;
    }

    public Task() {

    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDiscription() {
        return taskDiscription;
    }

    public void setTaskDiscription(String taskDiscription) {
        this.taskDiscription = taskDiscription;
    }

    public Long getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Long taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Long getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Long taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskAssign() {
        return taskAssign;
    }

    public void setTaskAssign(String taskAssign) {
        this.taskAssign = taskAssign;
    }


}
