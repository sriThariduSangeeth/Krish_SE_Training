package com.virtusa.lptraining.projectcomposerver.repository;

import com.virtusa.lpcommon.models.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
public interface ProjectRepository extends JpaRepository<Project, Integer > {

    Project save(Project project );

    Project findProjectByProjectId(int id);

    @Query(value="select projectActive from project p where p.projectId =:id", nativeQuery=true)
    boolean findProjectStateByProjectId(int id);

    @Override
    List<Project> findAll();

    @Modifying
    @Query(value = "select case when projectActive is 1 then 0 else 1 end BooleanOutput from project p where p.projectId =:id " , nativeQuery = true)
    Project updateProjectStateByProjectId(int id);
}
