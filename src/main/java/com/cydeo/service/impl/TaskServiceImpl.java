package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO task) {
        if (task.getTaskStatus()==null)
            task.setTaskStatus(Status.OPEN);
        if (task.getAssignedDate()==null)
        task.setAssignedDate(LocalDate.now());
        if (task.getId()==null)
        task.setId(UUID.randomUUID().getMostSignificantBits());
        return super.save(task.getId(), task);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO task) {
   // first we need to find the task that we have in the database, right now it is in our map

        TaskDTO foundTask = findById(task.getId()); // we need to leave same value for status and assingned value, the other field can change from the user side
        task.setTaskStatus(foundTask.getTaskStatus());
        task.setAssignedDate(foundTask.getAssignedDate());

        super.update(task.getId(), task);
    }  // i stay in here, here is gonna fix

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll()
                .stream()
                .filter(task->task.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }
}
