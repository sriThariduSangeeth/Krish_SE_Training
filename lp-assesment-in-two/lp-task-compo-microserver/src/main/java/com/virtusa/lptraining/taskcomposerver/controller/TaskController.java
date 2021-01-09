package com.virtusa.lptraining.taskcomposerver.controller;

import com.google.gson.Gson;
import com.virtusa.lpcommon.models.tascommons.ProjectInTaskResponse;
import com.virtusa.lpcommon.models.task.Task;
import com.virtusa.lptraining.taskcomposerver.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-task-compo-microserver
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public ResponseEntity<String> saveTask(@RequestBody Task task){
        log.info("Before Create new Task Check Project "+task.getProjectId()+" is Active");
        try {
            Task resTask = taskService.saveTask(task);
            if(resTask == null){
                log.info("Project mapping is invalid");
                return ResponseEntity.
                        status(HttpStatus.UNAUTHORIZED)
                        .body("Inactive Project id : "+task.getProjectId()+". JPA db error " );
            }else {
                return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(resTask));
            }

        }catch (JpaSystemException jp){
            log.error("JPA DB ERROR Object mapping",jp.getStackTrace());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Task id : "+task.getProjectId()+". JPA db error " );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findTaskById(@PathVariable("id") int id , @RequestParam(required = false) String type){
        log.info("Find Task using ID :" + id);

        try{
            ProjectInTaskResponse taskPro = taskService.fetchTaskById(id , type);
            if(taskPro == null){
                log.info("Invalid Id and Task does not exist");
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid Task id : "+id);
            }else {
                log.info("Valid Id and Task exist");
                return ResponseEntity.ok().body(new Gson().toJson(taskPro));
            }
        }catch (JpaSystemException exception) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Task id : "+id+". JPA db error " );
        }
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<String> findAllTaskByProjectId(@PathVariable("id") int id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(taskService.getAllTaskListByProjectId(id)));
        }catch (JpaSystemException spy){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Project id : "+id+". JPA db error " );
        }
    }



}
