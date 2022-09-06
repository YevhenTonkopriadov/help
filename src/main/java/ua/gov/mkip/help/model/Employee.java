package ua.gov.mkip.help.model;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String fio;
    private String email;

    public Employee(long id, String fio, String email) {
        this.id = id;
        this.fio = fio;
        this.email = email;
    }
}
