package com.virtusa.lptraining.projectcomposerver.services;

import com.virtusa.lpcommon.models.procommons.ProjectSimpleResponse;
import com.virtusa.lpcommon.models.procommons.TaskInProjectResponse;
import com.virtusa.lpcommon.models.project.Project;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Service
public interface ProjectService {

    Project saveProject(Project project);
    TaskInProjectResponse fetchProjectById(int id , String type) throws JpaSystemException;
    List<TaskInProjectResponse> fetchProjectBySate(boolean state , String type) throws JpaSystemException;
    boolean checkProjectStateById(int id) throws JpaSystemException;
    List<TaskInProjectResponse> getAllProjects (String type) throws JpaSystemException;
    Project updateProject(Project project) throws JpaSystemException;
    Project changeStateByProjectId(int id) throws JpaSystemException;

}
