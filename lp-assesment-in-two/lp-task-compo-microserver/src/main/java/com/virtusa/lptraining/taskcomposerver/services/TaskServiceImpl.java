package com.virtusa.lptraining.taskcomposerver.services;

import com.google.gson.Gson;
import com.virtusa.lptraining.taskcomposerver.entity.Project;
import com.virtusa.lptraining.taskcomposerver.entity.Task;
import com.virtusa.lptraining.taskcomposerver.model.TaskProjectMapping;
import com.virtusa.lptraining.taskcomposerver.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Override
    public Task saveTask(Task task) {
        log.info("Save new Task in SQL Task Table");
        String response = restTemplate.getForObject("http://localhost:8191/project/"+task.getProjectId(),String.class);
        Project project = new Gson().fromJson(response,Project.class);
        if(project.isProjectActive()){
            return taskRepository.save(task);
        }else {
            log.info(project.getProjectName()+ "Project is not Active.");
            return null;
        }
    }

    @Override
    public TaskProjectMapping fetchTaskById(int id) {
        TaskProjectMapping tp = new TaskProjectMapping();
        Task task = taskRepository.findTaskByTaskId(id);

        String response = restTemplate.getForObject("http://localhost:8191/project/"+task.getProjectId(), String.class);

        Project project = new Gson().fromJson(response,Project.class);

        tp.setTask(task);
        tp.setProject(project);

        if(task == null){
            log.info("Task ID "+ id + " does not exsit");
            return null;
        }else {
            return tp;
        }
    }
}
