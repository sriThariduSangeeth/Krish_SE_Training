package com.virtusa.lptraining.projectcomposerver.services;

import com.virtusa.lptraining.projectcomposerver.entity.Project;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Service
public interface ProjectService {

    Project saveProject(Project project);
    Project fetchProjectById(int id);

}
