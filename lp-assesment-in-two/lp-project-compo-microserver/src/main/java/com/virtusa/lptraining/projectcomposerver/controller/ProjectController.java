package com.virtusa.lptraining.projectcomposerver.controller;

import com.virtusa.lptraining.projectcomposerver.entity.Project;
import com.virtusa.lptraining.projectcomposerver.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping("/")
    public String saveProject(@RequestBody String project){

        projectService.saveProject(project);
        return "";
    }

    @GetMapping("/{id}")
    public String findProjectById(@PathVariable("id") int id){

        return "Hello "+id ;
    }
}
