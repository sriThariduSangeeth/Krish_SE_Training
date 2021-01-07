package com.virtusa.lptraining.taskcomposerver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-task-compo-microserver
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="task")
public class Task  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    private int projectId;
    private String taskName;
    private String taskDiscription;
    private Long taskStartDate;
    private Long taskEndDate;
    private String taskPriority;
    private String taskStatus;
    private String taskAssign;
}
