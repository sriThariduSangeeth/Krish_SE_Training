package com.sangeeth.lptraining.projectcomposerver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    private String projectName;
    private String progectDiscription;
    private Long projectStartDate;
    private Long projectEndDate;
    private boolean projectActive;

}
