package com.virtusa.lptraining.projectcomposerver.controller;

import com.google.gson.Gson;
import com.virtusa.lptraining.projectcomposerver.entity.Project;
import com.virtusa.lptraining.projectcomposerver.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("")
    public String saveProject(@RequestBody Project project){
        return new Gson().toJson(projectService.saveProject(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findProjectById(@PathVariable("id") int id){
        Project project = projectService.fetchProjectById(id);
        if(project == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(new Gson().toJson(project));
        }
    }

}
