package com.virtusa.lptraining.projectcomposerver.services;

import com.virtusa.lptraining.projectcomposerver.entity.Project;
import com.virtusa.lptraining.projectcomposerver.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public void saveProject(String project) {
        System.out.println(project);
    }
}
