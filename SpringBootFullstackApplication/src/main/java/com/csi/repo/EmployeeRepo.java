package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    //custom methods from here
    public Employee findByEmpId(int empId);

    public Employee findByEmpName(String empName);

    public Employee findByEmpContactNumber(long empContactNumber);

    public Employee findByEmpUID(long empUID);

    public Employee findByEmpDOB(Date empDOB);

    public Employee findByEmpEmailId(String empEmailId);
    public Employee findByEmpPanCard(String empPan);
}
