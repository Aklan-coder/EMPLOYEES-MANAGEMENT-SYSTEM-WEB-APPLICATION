package Project2.EmloyeeManagementSystem.EmployeeSystem;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface  EmployeeService {
     List<Employee> getAllEmployees();
     void SaveEmployee (Employee employee);
     Employee getEmployeeById(Long id);
     void deleteEmployeeById(Long id);
}
