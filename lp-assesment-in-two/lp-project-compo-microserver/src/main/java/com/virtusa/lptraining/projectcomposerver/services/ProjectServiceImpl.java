package com.virtusa.lptraining.projectcomposerver.services;

import com.virtusa.lptraining.projectcomposerver.entity.Project;
import com.virtusa.lptraining.projectcomposerver.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.Optional;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
         return projectRepository.save(project);
    }

    public Project fetchProjectById(int id){
        Project project =  projectRepository.findProjectByProjectId(id);
        if(project == null){
            return null;
        }else {
            return project;
        }
    }
}
