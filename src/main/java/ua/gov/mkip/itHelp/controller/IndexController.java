package ua.gov.mkip.itHelp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.gov.mkip.itHelp.model.Employee;
import ua.gov.mkip.itHelp.servises.EmployeeServises;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final EmployeeServises employeeServises;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("title", "Головна");
        return "index";
    }


    @GetMapping("showEmployee/{inputString}")
    @ResponseBody
    public Iterable<Employee> showEmployee(@PathVariable("inputString") String inputString) {
        return employeeServises.finAllByPartOfFio(inputString);
    }
}
