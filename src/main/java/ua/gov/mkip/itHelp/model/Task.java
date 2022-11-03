package ua.gov.mkip.itHelp.model;

import lombok.Data;
import ua.gov.mkip.itHelp.model.enums.TypeOfProblem;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private TypeOfProblem typeOfProblem;

    private String descriptionOfProblem;

    private Date dataOfGenerationTask;

    private Date dataOfTakeTaskInWork;

    private Date DateOfSolveProblem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private Master master;


}
