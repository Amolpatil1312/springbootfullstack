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

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public long getEmpContactNumber() {
        return empContactNumber;
    }

    public void setEmpContactNumber(long empContactNumber) {
        this.empContactNumber = empContactNumber;
    }

    public long getEmpUID() {
        return empUID;
    }

    public void setEmpUID(long empUID) {
        this.empUID = empUID;
    }

    public String getEmpPanCard() {
        return empPanCard;
    }

    public void setEmpPanCard(String empPanCard) {
        this.empPanCard = empPanCard;
    }

    public Date getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(Date empDOB) {
        this.empDOB = empDOB;
    }

    public String getEmpEmailId() {
        return empEmailId;
    }

    public void setEmpEmailId(String empEmailId) {
        this.empEmailId = empEmailId;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }
}
