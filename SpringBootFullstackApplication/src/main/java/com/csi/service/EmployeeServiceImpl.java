package com.csi.service;

import com.csi.exeption.RecordNotFoundExeption;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee SignUp(Employee employee) {

        return employeeRepo.save(employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        boolean flag = false;
        for (Employee employee : findAll()) {
            if (employee.getEmpEmailId().equals(empEmailId) &&
                    employee.getEmpPassword().equals(empPassword)) {
                flag = true;

            }
        }

        return flag;
    }

    public Employee findByName(String empName) {
        return employeeRepo.findByEmpName(empName);
    }

    public Employee findByContactNumber(long empContactNumber) {
        return employeeRepo.findByEmpContactNumber(empContactNumber);
    }

    public Employee findByUID(long empUID) {
        return employeeRepo.findByEmpUID(empUID);
    }

    public Employee findByDOB(Date empDOB) {
        return employeeRepo.findByEmpDOB(empDOB);
    }

    public Employee findByEmailId(String empEmailId) {
        return employeeRepo.findByEmpEmailId(empEmailId);
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> saveBulkOfData(List<Employee> empList) {

        return employeeRepo.saveAll(empList);
    }

    @Override
    public List<Employee> findByAnyInput(String anyInput) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date empdate = dateFormat.parse(anyInput);

        return employeeRepo.findAll().stream().filter(emp ->
                emp.getEmpId() == Integer.parseInt(anyInput) ||
                        emp.getEmpName().equals(anyInput) ||
                        emp.getEmpUID() == Long.parseLong(anyInput) ||
                        emp.getEmpDOB().equals(empdate) ||
                        emp.getEmpEmailId().equals(anyInput) ||
                        emp.getEmpSalary() == Double.parseDouble(anyInput) ||
                        emp.getEmpPanCard().equals(anyInput) ||
                        emp.getEmpContactNumber() == Long.parseLong(anyInput)).toList();
    }

    public Employee findById(int empId) {
        return employeeRepo.findById(empId).orElseThrow(() -> new RecordNotFoundExeption("This Record is Not available to the Data base"));
    }

    @Override
    public Employee updateById(int empId, Employee employee) {
        Employee employee1 = findById(empId);
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpPanCard(employee.getEmpPanCard());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpUID(employee.getEmpUID());
        return employee1;
    }

    @Override
    public void deleteById(int empId) {
        employeeRepo.deleteById(empId);
    }

    @Override
    public void deleteAll() {
        employeeRepo.deleteAll();
    }

    public Employee findByEmpPanCard(String empPan) {
        return employeeRepo.findByEmpPanCard(empPan);
    }
}
