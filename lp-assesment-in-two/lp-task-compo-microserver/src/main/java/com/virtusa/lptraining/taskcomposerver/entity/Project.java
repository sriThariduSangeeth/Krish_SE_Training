package com.virtusa.lptraining.taskcomposerver.entity;

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
public class Project {

    private int projectId;
    private String projectName;
    private String progectDiscription;
    private Long projectStartDate;
    private Long projectEndDate;
    private boolean projectActive;
}
