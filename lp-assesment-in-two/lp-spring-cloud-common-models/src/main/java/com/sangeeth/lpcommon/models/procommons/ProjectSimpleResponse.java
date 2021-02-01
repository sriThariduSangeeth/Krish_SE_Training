package com.sangeeth.lpcommon.models.procommons;

import com.sangeeth.lpcommon.models.project.Project;

/**
 * @author dtsangeeth
 * @created 09 / 01 / 2021
 * @project lp-spring-cloud-common-models
 */
public class ProjectSimpleResponse implements TaskInProjectResponse{

    private Project project;


    public ProjectSimpleResponse(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
