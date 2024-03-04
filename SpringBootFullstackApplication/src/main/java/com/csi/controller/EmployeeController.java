package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signUp")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee){
       return new ResponseEntity<>(employeeServiceImpl.SignUp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/signIn/{empEmailId}/{empPassword}")
    public ResponseEntity<String> signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        String msg = "";
        if(employeeServiceImpl.signIn(empEmailId, empPassword)){
            msg = "Welcome to HRM Application Swaagat hai Apaka";
        }else {
            msg = "Password is Incorrect Please Try Again";
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/findById/{empId}")
    public ResponseEntity<Employee> findById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.findById(empId));
    }

    @GetMapping("/findByName/{empName}")
    public ResponseEntity<Employee> findByName(String empName){
        return ResponseEntity.ok(employeeServiceImpl.findByName(empName));
    }

    @GetMapping("/findByContactNumber/{empContactNumber}")
    public ResponseEntity<Employee> findByContactNumber(@PathVariable long empContactNumber){
        return ResponseEntity.ok(employeeServiceImpl.findByContactNumber(empContactNumber));
    }

    @GetMapping("/findByUID/{empUID}")
    public ResponseEntity<Employee> findByUID(@PathVariable long empUID){
        return ResponseEntity.ok(employeeServiceImpl.findByUID(empUID));
    }

    @GetMapping("/findByPanCard/{empPan}")
    public ResponseEntity<Employee> findByPanCard(@PathVariable String empPan){
        return ResponseEntity.ok(employeeServiceImpl.findByEmpPanCard(empPan));
    }

    @GetMapping("/findByDOB/{empDOB}")
    public ResponseEntity<Employee> findByDOB(@PathVariable Date empDOB){
        return ResponseEntity.ok(employeeServiceImpl.findByDOB(empDOB));
    }

    @GetMapping("/findByEmailId/{empEmailId}")
    public ResponseEntity<Employee> findByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.findByEmailId(empEmailId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }

    @PostMapping("/saveBulkOfData/{employeeList}")
    public ResponseEntity<List<Employee>> saveBulkData(@PathVariable List<Employee> employeeList){
        return ResponseEntity.ok(employeeServiceImpl.saveBulkOfData(employeeList));
    }

    @GetMapping("/findByAnyInput/{anyInput}")
    public ResponseEntity<List<Employee>> findByAnyInput(@PathVariable String anyInput) throws ParseException {
        return ResponseEntity.ok(employeeServiceImpl.findByAnyInput(anyInput));
    }

    @GetMapping("/sortById")
    public ResponseEntity<List<Employee>> sortById(){
        return ResponseEntity.ok(employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpId)).toList());
    }

    @GetMapping("/sortByDOB")
    public ResponseEntity<List<Employee>> sortByBOB(){
        return ResponseEntity.ok(employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpDOB)).toList());
    }

    @GetMapping("/sortByName")
    public ResponseEntity<List<Employee>> sortByName(){
        return ResponseEntity.ok(employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).toList());
    }

    @GetMapping("/sortBySalary")
    public ResponseEntity<List<Employee>> sortBySalary(){
        return ResponseEntity.ok(employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpSalary)).toList());
    }

    @GetMapping("/filterBySalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterBySalary(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpSalary()>=empSalary).toList());
    }

    @PutMapping("/updateById/{empId}")
    public ResponseEntity<Employee> updateById(@PathVariable int empId,@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.updateById(empId,employee));
    }

    @DeleteMapping("/deleteById/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Employee Data Deleted Successfully...");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        employeeServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }
}

