package com.virtusa.lptraining.taskcomposerver.model;

import com.virtusa.lptraining.taskcomposerver.entity.Project;
import com.virtusa.lptraining.taskcomposerver.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dtsangeeth
 * @created 07 / 01 / 2021
 * @project lp-task-compo-microserver
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskProjectMapping {

    private Task task;
    private Project project;
}
