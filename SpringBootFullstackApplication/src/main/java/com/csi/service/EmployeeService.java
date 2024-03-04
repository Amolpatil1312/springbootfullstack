package com.csi.service;

import com.csi.model.Employee;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {

    public Employee SignUp(Employee employee);

    public boolean signIn(String empEmailId,String empPassword);

    public List<Employee> findAll();

    public List<Employee> saveBulkOfData(List<Employee> empList);

    public List<Employee> findByAnyInput(String anyInput) throws ParseException;

    public Employee updateById(int empId,Employee employee);

    public void deleteById(int empId);

    public void deleteAll();


}
