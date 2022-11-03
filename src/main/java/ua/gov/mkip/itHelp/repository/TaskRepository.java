package ua.gov.mkip.itHelp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.gov.mkip.itHelp.model.Task;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}
