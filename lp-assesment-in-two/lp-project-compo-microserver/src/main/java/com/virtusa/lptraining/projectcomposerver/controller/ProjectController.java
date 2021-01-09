package com.virtusa.lptraining.projectcomposerver.controller;

import com.google.gson.Gson;
import com.virtusa.lpcommon.models.procommons.TaskInProjectResponse;
import com.virtusa.lpcommon.models.project.*;
import com.virtusa.lptraining.projectcomposerver.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @PostMapping("/")
    public String saveProject(@RequestBody Project project){
        log.info("Create new Project");
        return new Gson().toJson(projectService.saveProject(project));
    }

    @GetMapping("/")
    public ResponseEntity<String> getAllProjectLst(@RequestParam(required = false) String type){

        try {
            List<TaskInProjectResponse> prores = projectService.getAllProjects(type);
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(prores));
        }catch (JpaSystemException jp){
            log.error("Project table configuration failed", jp.getStackTrace());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Project Table. JPA db error " );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findProjectById(@PathVariable("id") int id , @RequestParam(required = false) String type){
        log.info("Find Project using ID :" + id);
        TaskInProjectResponse project = projectService.fetchProjectById(id , type);
        if(project == null){
            log.error("Invalid Id and Project does not exist");
            return ResponseEntity.notFound().build();
        }else {
            log.info("Invalid Id and Project does not exist");
            return ResponseEntity.ok().body(new Gson().toJson(project));
        }
    }
    @GetMapping("/{id}/state")
    public ResponseEntity<String> checkProjectState(@PathVariable("id") int id){

        try {
            boolean res = projectService.checkProjectStateById(id);
            if(res){
                log.info("Project id : "+ id +" is Active");
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Active");
            }else {
                log.info("Project id : "+ id +" is Inactive");
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Inactive");
            }

        }catch (JpaSystemException jp){
            log.error("Project table configuration failed", jp.getStackTrace());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Project id : "+id+". JPA db error " );
        }
    }

}
