package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService <ProjectDTO, String> implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {

        if (project.getProjectStatus()==null)
            project.setProjectStatus(Status.OPEN);
    //the another small topic, may be you can talk challenges, when we try to new project and there is no status project details, but it is needed in the project list in the view page
    //so we need to before save i need to setStatus Open and then i can save

        return super.save(project.getProjectCode(), project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
        if (object.getProjectStatus()==null) { // there is not status for update in the form in the UI, but it became null by default so to avoid this error
        object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());}
        //the another small topic, may be you can talk challenges, when we try to update and then we put save button, there is no status project details
        // so we need to before update i need to setStatus grabbing the current status project from the database and then i can update
    super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }


    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        List<ProjectDTO> projectList =
                findAll()
                        .stream()
                        .filter(project->project.getAssignedManager().equals(manager))
                        .map(project-> {
                            // all the tasks belongs to this project

                            List<TaskDTO> taskList = taskService.findTasksByManager(manager);
                            int completeTaskCount = (int)taskList.stream().filter(task-> task.getProject().equals(project) && task.getTaskStatus()==Status.COMPLETE).count();
                            int unFinishedTaskCount = (int) taskList.stream().filter(task-> task.getProject().equals(project) && (task.getTaskStatus()!=Status.COMPLETE)).count();
                            project.setCompleteTaskCounts(completeTaskCount);
                            project.setUnfinishedTaskCounts(unFinishedTaskCount);
                            return project;
                        })
                        .toList();

        return projectList;
    }

}
