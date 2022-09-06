package ua.gov.mkip.help.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.gov.mkip.help.model.Employee;
import java.util.ArrayList;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index (Model model){
        model.addAttribute("title", "Головна");
        return "index";
    }

    @GetMapping("showEmployee/{inputString}")
    @ResponseBody
    public ArrayList <Employee> showEmployee(@PathVariable("inputString") String inputString) {
            ArrayList <Employee> employeeList = new ArrayList<>();
            employeeList.add(new Employee(1,"user","mail@mail.com"));
            employeeList.add(new Employee(12,"admin","mail@mail.com"));
            employeeList.add(new Employee(123,"3","mail3@mail.com"));
        return employeeList;
    }

}
