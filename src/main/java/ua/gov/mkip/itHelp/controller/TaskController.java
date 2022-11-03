package ua.gov.mkip.itHelp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.gov.mkip.itHelp.model.Task;
import ua.gov.mkip.itHelp.repository.TaskRepository;
import ua.gov.mkip.itHelp.servises.EmployeeServises;
import ua.gov.mkip.itHelp.servises.TaskServises;

import java.time.Instant;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final EmployeeServises employeeServises;
    private final TaskServises taskServises;

    @GetMapping(value = "addNewProblemByUserId/{id}")
    public String addNewProblem(Model model, @PathVariable("id") String userIdString) {
        try {
            Integer userId = Integer.parseInt(userIdString);
            Task task = new Task();
            if (employeeServises.finById(userId.longValue()).isPresent()) {
                task.setEmployee(employeeServises.finById(userId.longValue()).get());
                model.addAttribute("task", task);
                return "addNewProblem";
            } else {
                return "index";
            }
        } catch (NumberFormatException e) {
            return "index";
        }
    }

    @PostMapping(value = "addTask")
    public String addTask (Model model,  @ModelAttribute Task task){
        task.setDataOfGenerationTask(Date.from(Instant.now()));
        taskServises.saveTask(task);
        return "addTaskResult";
    }
    @GetMapping (value = "allTask")
    public String findAllTask (Model model){
        model.addAttribute("tasksList", taskServises.findAll());
        return "allTask";
    }
}
