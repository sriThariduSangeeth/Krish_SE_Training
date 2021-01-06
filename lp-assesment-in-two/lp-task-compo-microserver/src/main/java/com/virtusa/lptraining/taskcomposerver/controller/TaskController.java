package com.virtusa.lptraining.taskcomposerver.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-task-compo-microserver
 */

@RestController
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/{id}")
    public String addTask(@PathVariable("id") int id){
        return "grefefs";
    }
}
