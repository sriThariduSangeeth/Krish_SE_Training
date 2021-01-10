package com.virtusa.lptraining.projectcomposerver.services;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.virtusa.lpcommon.models.procommons.ProjectDetailResponse;
import com.virtusa.lpcommon.models.procommons.ProjectSimpleResponse;
import com.virtusa.lpcommon.models.procommons.TaskInProjectResponse;
import com.virtusa.lpcommon.models.project.Project;
import com.virtusa.lpcommon.models.task.Task;
import com.virtusa.lptraining.projectcomposerver.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.virtusa.lptraining.projectcomposerver.utils.Constants.TASK_SERVICE_BASE_URL;

/**
 * @author dtsangeeth
 * @created 06 / 01 / 2021
 * @project lp-project-compo-microserver
 */
@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${"+TASK_SERVICE_BASE_URL+"}")
    private String taskBaseurl;

    @Override
    public Project saveProject(Project project) {
         log.info("Save new Project in SQL Project Table");
         return projectRepository.save(project);
    }

    @Override
    public TaskInProjectResponse fetchProjectById(int id , String type) throws JpaSystemException{
        Project project =  projectRepository.findProjectByProjectId(id);

        if(type != null && type.equalsIgnoreCase("all")){
            if(project == null){
                return null;
            }else {
                return new ProjectDetailResponse(project, getAllTaskForProject(project.getProjectId()));
            }
        }else {
            if(project == null){
                return null;
            }else {
                return new ProjectSimpleResponse(project);
            }
        }

    }

    @Override
    public List<TaskInProjectResponse> fetchProjectBySate(boolean state, String type) throws JpaSystemException {
        List<Project> resPro = projectRepository.findProjectByProjectActive(state);
        return returnAllValidProjectObj(resPro,type);
    }

    private List<TaskInProjectResponse> returnAllValidProjectObj (List<Project> proj , String type){
        List<TaskInProjectResponse> finalList = new ArrayList<>();

        if (type != null && type.equalsIgnoreCase("all")){
            if (!proj.isEmpty()){
                proj.forEach(pro ->{
                    finalList.add( new ProjectDetailResponse(pro,getAllTaskForProject(pro.getProjectId())));
                });
            }

        }else {
            if (!proj.isEmpty()){
                proj.forEach(project -> {
                    finalList.add(new ProjectSimpleResponse(project));
                });
            }
        }

        return finalList;
    }

    private List<Task> getAllTaskForProject(int id){
        Type listType = new TypeToken<List<Task>>() {}.getType();
        String resa = restTemplate.getForObject(taskBaseurl+"/project/"+id,String.class);
        List<Task> res = new Gson().fromJson(resa , listType);
        return res;
    }

    @Override
    public boolean checkProjectStateById(int id) throws JpaSystemException {
        return  projectRepository.findProjectStateByProjectId(id);
    }

    @Override
    public List<TaskInProjectResponse> getAllProjects(String type) throws JpaSystemException {
        List<Project> prores = projectRepository.findAll();
        return returnAllValidProjectObj(prores,type);
    }

    @Override
    public Project updateProject(Project project) throws JpaSystemException {
        log.info("Update "+project.getProjectName()+" Project in SQL Project Table");
        return projectRepository.save(project);
    }

    @Override
    public Project changeStateByProjectId(int id) throws JpaSystemException {

        if(projectRepository.findProjectStateByProjectId(id)){
            return projectRepository.updateProjectStateByProjectId(false);
        }else {
            return projectRepository.updateProjectStateByProjectId(true);
        }
    }


}
