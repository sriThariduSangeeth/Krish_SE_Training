package com.sangeeth.lptraining.taskcomposerver.services;

import com.google.gson.Gson;
import com.sangeeth.lptraining.taskcomposerver.repository.TaskRepository;
import com.sangeeth.lptraining.taskcomposerver.utils.Constants;
import com.virtusa.lpcommon.models.procommons.ProjectSimpleResponse;
import com.virtusa.lpcommon.models.tascommons.ProjectInTaskResponse;
import com.virtusa.lpcommon.models.tascommons.TaskDetailResponse;
import com.virtusa.lpcommon.models.tascommons.TaskSimpleResponse;
import com.virtusa.lpcommon.models.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author dtsangeeth
 * @created 07 / 01 / 2021
 * @project lp-task-compo-microserver
 */
@Slf4j
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${"+ Constants.PROJECT_SERVICE_BASE_URL+"}")
    private String projectBaseurl;

    @Override
    public Task saveTask(Task task) throws JpaSystemException{
        log.info("Save new Task in SQL Task Table");
        String response = restTemplate.getForObject(projectBaseurl+"/state/"+task.getProjectId(),String.class);
        if(response.equalsIgnoreCase("Active")){
            return taskRepository.save(task);
        }else {
            log.info(task.getProjectId()+ "Project is not Active.");
            return null;
        }
    }

    @Override
    public ProjectInTaskResponse fetchTaskById(int id , String type) throws JpaSystemException {

        Task task = taskRepository.findTaskByTaskId(id);
        ProjectSimpleResponse project = null;
        ProjectInTaskResponse projectInTaskResponse;
        if(task != null) {
            if (type != null && type.equalsIgnoreCase("all")) {
                String response = restTemplate.getForObject(projectBaseurl + task.getProjectId(), String.class);
                project = new Gson().fromJson(response, ProjectSimpleResponse.class);
                projectInTaskResponse = new TaskDetailResponse(task, project.getProject());
            } else {

                projectInTaskResponse = new TaskSimpleResponse(task);
            }

            return projectInTaskResponse;
        } else {
            return null;
        }
    }

    @Override
    public List<Task> getAllTaskListByProjectId(int id) throws JpaSystemException {
        return taskRepository.findTasksByProjectId(id);
    }
}
