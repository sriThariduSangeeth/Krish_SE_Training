package com.virtusa.lptraining.projectcomposerver.repository;

import com.virtusa.lptraining.projectcomposerver.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
public interface ProjectRepository extends JpaRepository<Project, Integer > {

    Project save(Project project );
    Project findProjectByProjectId(int id);
}
