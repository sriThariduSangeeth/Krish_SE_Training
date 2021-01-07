package com.virtusa.lptraining.taskcomposerver.controller;

import com.google.gson.Gson;
import com.virtusa.lptraining.taskcomposerver.entity.Task;
import com.virtusa.lptraining.taskcomposerver.model.TaskProjectMapping;
import com.virtusa.lptraining.taskcomposerver.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        log.info("Create new Task");
        Task resTask = taskService.saveTask(task);

        if(resTask == null){
            log.info("Project mapping is invalid");
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(new Gson().toJson(resTask));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findTaskById(@PathVariable("id") int id){
        log.info("Find Task using ID :" + id);
        TaskProjectMapping taskPro = taskService.fetchTaskById(id);
        if(taskPro == null){
            log.info("Invalid Id and Task does not exist");
            return ResponseEntity.notFound().build();
        }else {
            log.info("Invalid Id and Task does not exist");
            return ResponseEntity.ok().body(new Gson().toJson(taskPro));
        }
    }



}
