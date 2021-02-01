package com.sangeeth.lpcommon.models.project;

import javax.persistence.*;

/**
 * @author dtsangeeth
 * @created 07 / 01 / 2021
 * @project lp-spring-cloud-common-models
 */
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    private String projectName;
    private String progectDiscription;
    private Long projectStartDate;
    private Long projectEndDate;
    private boolean projectActive;

    public Project() {
    }

    public Project(int projectId, String projectName, String progectDiscription, Long projectStartDate, Long projectEndDate, boolean projectActive) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.progectDiscription = progectDiscription;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectActive = projectActive;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProgectDiscription() {
        return progectDiscription;
    }

    public void setProgectDiscription(String progectDiscription) {
        this.progectDiscription = progectDiscription;
    }

    public Long getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Long projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Long getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Long projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public boolean isProjectActive() {
        return projectActive;
    }

    public void setProjectActive(boolean projectActive) {
        this.projectActive = projectActive;
    }
}
