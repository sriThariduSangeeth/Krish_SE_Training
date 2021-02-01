package com.sangeeth.lptraining.projectcomposerver.controller;

import com.google.gson.Gson;
import com.sangeeth.lptraining.projectcomposerver.services.ProjectService;
import com.sangeeth.lpcommon.models.procommons.TaskInProjectResponse;
import com.sangeeth.lpcommon.models.project.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /** Tested call
     * TODO - Exception Handle
     * @RETURN - Save new project
     * @PARAM - Project Object
     **/
    @PostMapping("")
    public String saveProject(@RequestBody Project project){
        log.info("Create new Project");
        return new Gson().toJson(projectService.saveProject(project));
    }

    /** Tested call
     TODO - Exception Handle
     @RETURN - list of Projects
     @PARM - type = "all"
     */
    @GetMapping("")
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

    /** Tested call
     * TODO - Exception Handle
     * @RETURN - Update project
     * @PARAM - project Object
     **/
    @PutMapping("")
    public ResponseEntity<String> updateProject(@RequestBody Project project){
        try {
            Project pro = projectService.updateProject(project);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Gson().toJson(pro));
        }catch (JpaSystemException jp){
            log.error("Project table configuration failed", jp.getStackTrace());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Project. Project does not exist. JPA db error " );
        }
    }

    /** Tested call
     * TODO - Exception Handle
     * @RETURN - Get project by projectId
     * @PARAM - projectId and type = "all"
     **/
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

    /** Tested call
     * TODO - Exception Handle
     * @RETURN - Get All Active and Inactive Project
     * @PARAM - state = "Active or Inactive" and type = "all"
     **/
    @GetMapping("/{state}")
    public ResponseEntity<String> getAllProjectByState(@PathVariable("state") boolean state , @RequestParam(required = false) String type){

        log.info("Find Project using State :" + state);
        if (Boolean.valueOf(state)){
            List<TaskInProjectResponse> project = projectService.fetchProjectBySate(state,type);
            if(project == null){
                log.error("Invalid state and Project does not exist");
                return ResponseEntity.notFound().build();
            }else {
                log.info("Valid state and Projects exist");
                return ResponseEntity.ok().body(new Gson().toJson(project));
            }
        }else {
            log.error("Invalid state and Project does not exist");
            return ResponseEntity.notFound().build();
        }

    }

    /** Tested call
     * TODO - Exception Handle
     * @RETURN - Get project is Active ot not
     * @PARAM - projectId
     **/
    @GetMapping("/state/{id}")
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

    /** Tested call
     * TODO - Exception Handle
     * @RETURN - Update project is Active ot not
     * @PARAM - projectId
     **/
    @PutMapping("/state/{id}")
    public ResponseEntity<String> changeStateByProjectId(@PathVariable("id") int id){
        try {
            Project pro = projectService.changeStateByProjectId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Gson().toJson(pro));
        }catch (JpaSystemException jp){
            log.error("Project table configuration failed", jp.getStackTrace());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Project id : "+id+". JPA db error " );
        }
    }

}
