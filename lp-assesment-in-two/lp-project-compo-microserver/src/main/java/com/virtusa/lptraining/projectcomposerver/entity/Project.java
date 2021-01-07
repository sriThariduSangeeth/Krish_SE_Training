package com.virtusa.lptraining.projectcomposerver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Entity
public class Project {

    @Id
    private int projectId;
    private String projectName;
    private String progectDiscription;
    private Long projectStartDate;
    private Long projectEndDate;
    private boolean projectActive;


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
