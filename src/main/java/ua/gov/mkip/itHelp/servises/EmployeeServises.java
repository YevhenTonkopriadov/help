package ua.gov.mkip.itHelp.servises;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.gov.mkip.itHelp.model.Employee;
import ua.gov.mkip.itHelp.repository.EmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServises {

    private final EmployeeRepository employeeRepository;

    public Iterable<Employee> finAll() {
        return employeeRepository.findAll();
    }

    public void seve(Employee employee) {
        employeeRepository.save(employee);
    }

    public Iterable<Employee> finAllByPartOfFio(String inputString) {
        return employeeRepository.finAllByPartOfFio(inputString);
    }

    public Optional<Employee> finById(Long userId) {
        return employeeRepository.findById(userId);
    }
}
