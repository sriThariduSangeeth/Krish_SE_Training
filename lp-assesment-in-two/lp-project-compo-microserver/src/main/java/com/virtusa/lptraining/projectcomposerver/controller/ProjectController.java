package com.virtusa.lptraining.projectcomposerver.controller;

import com.google.gson.Gson;
import com.virtusa.lptraining.projectcomposerver.entity.Project;
import com.virtusa.lptraining.projectcomposerver.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping("")
    public String saveProject(@RequestBody Project project){
        log.info("Create new Project");
        return new Gson().toJson(projectService.saveProject(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findProjectById(@PathVariable("id") int id){
        log.info("Find Project using ID :" + id);
        Project project = projectService.fetchProjectById(id);
        if(project == null){
            log.info("Invalid Id and Project does not exist");
            return ResponseEntity.notFound().build();
        }else {
            log.info("Invalid Id and Project does not exist");
            return ResponseEntity.ok().body(new Gson().toJson(project));
        }
    }

}
