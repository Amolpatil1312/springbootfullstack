package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Size(min =4,message = "The Size of the Name must be 4 chars")
    private String empName;

    private transient double empSalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Employee Contact Number must be 10 digit")
    private long empContactNumber;

    @Column(unique = true)
    private long empUID;

    @Column(unique = true)
    private String empPanCard;

    @JsonFormat(pattern = "dd-MM-yyyy",timezone = "asia/kolkata")
    @Temporal(TemporalType.DATE)
    private Date empDOB;

    @Email(message = "Email Must be valid")
    @Column(unique = true)
    private String empEmailId;

    @Size(min = 5,message = "Password Should least 5 chars")
    private String empPassword;

}
