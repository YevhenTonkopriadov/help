package ua.gov.mkip.itHelp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@DiscriminatorValue("1")
public class Master extends Employee {

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Task> tasks;
}
