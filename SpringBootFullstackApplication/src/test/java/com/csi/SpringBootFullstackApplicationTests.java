package com.csi;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.security.RunAs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootFullstackApplicationTests {

    @Autowired
    EmployeeService employeeServiceImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;

    @Test
    public void deleteByIdTest() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Employee employee = new Employee(101,"amol",45000,7845654125L,7845695454L,"78545KHH",new Date(),"beamolpatil@gmail.com","amol123");
        employeeServiceImpl.deleteById(employee.getEmpId());
        Mockito.verify(employeeRepoImpl,Mockito.times(1)).deleteById(employee.getEmpId());
    }
    @Test
    public void findAllTest(){
        Mockito.when(employeeServiceImpl.findAll()).thenReturn(Stream.of(new Employee(101,"amol",78454,546878678L,7874646461L,"jhjf123",new Date(),"beamolpatul@gmail.com","amol123")).toList());
        Mockito.verify(employeeRepoImpl,Mockito.times(employeeServiceImpl.findAll().size())).findAll();
    }

    @Test
    public void deleteAll(){
        Employee employee = new Employee(101,"amol",45000,7845654125L,7845695454L,"78545KHH",new Date(),"beamolpatil@gmail.com","amol123");
        employeeServiceImpl.deleteAll();
        Mockito.verify(employeeRepoImpl,Mockito.times(1)).deleteAll();

    }

    @Test
    public void saveTest(){
        Employee employee = new Employee(101,"amol",45000,8735476787l,66876874354l,"65465467kGKHG",new Date(),"beamol@gmail.com","amol123");
        employeeServiceImpl.SignUp(employee);
        Mockito.verify(employeeRepoImpl,Mockito.times(1)).save(employee);
    }





}
