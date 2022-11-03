package ua.gov.mkip.itHelp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.gov.mkip.itHelp.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Query(value = "SELECT empl from  Employee empl WHERE empl.fio LIKE CONCAT('%',:fio,'%')")
    Iterable<Employee> finAllByPartOfFio(String fio);
}
