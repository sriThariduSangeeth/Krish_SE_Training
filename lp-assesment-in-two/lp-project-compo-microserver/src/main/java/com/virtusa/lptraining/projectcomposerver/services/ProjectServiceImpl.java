package com.virtusa.lptraining.projectcomposerver.services;

import com.virtusa.lptraining.projectcomposerver.entity.Project;
import com.virtusa.lptraining.projectcomposerver.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.Optional;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
         log.info("Save new Project in SQL Project Table");
         return projectRepository.save(project);
    }

    @Override
    public Project fetchProjectById(int id){
        Project project =  projectRepository.findProjectByProjectId(id);
        if(project == null){
            return null;
        }else {
            return project;
        }
    }
}
